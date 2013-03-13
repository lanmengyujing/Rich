package com.jing.rich;

import com.jing.rich.action.*;
import com.jing.rich.exception.PropNotOwnException;
import com.jing.rich.exception.UpdateException;
import com.jing.rich.ground.*;
import com.jing.rich.tools.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-23
 * Time: 下午3:18
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    private int position;
    private int money;
    private Assets assets;
    private Role role;
    private int points = 0;
    private int fuShenTime = 0;
    private int cancelTimes = 0;
    private Map<Prop, Integer> props = new HashMap<Prop, Integer>();

    public Player(int position, int money, Role role, Assets assets) {
        this.position = position;
        this.money = money;
        this.assets = assets;
        this.role = role;
    }


    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public Assets getAssets() {
        return assets;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return role.getName();
    }

    public boolean isBankrupt() {
        boolean flag = false;
        if (money <= 0) {
            flag = true;
            List<Land> landList = assets.getAssetsList();
            for (Land land : landList) {
                land.reSetting();
            }
            assets = null;
            points = 0;
            props = null;
        }
        return flag;
    }

    public void move(int step, RichMap richMap) {
        removePlayerFromPrePosition(richMap);
        walkToFront(step, richMap);
        addPlayerToCurPosition(richMap);
    }

    private void walkToFront(int step, RichMap richMap) {
        int pos;
        for (int i = 1; i <= step; i++) {
            pos = (position + i) % Phrases.GROUND_COUNT;
            Ground ground = richMap.getGround(pos);
            if (ground.hasProp()) {
                Prop prop = ground.getProp();
                if (prop.equals(Prop.ROAD_BLOCK)) {
                    position = pos;
                    ground.removeProp();
                    IO.writeTo(getName() + Phrases.BE_BLOCK);
                    return;
                } else if (prop.equals(Prop.BOMB)) {
                    position = Phrases.HOSPITAL_POS;
                    cancelTimes = Phrases.IN_HOSPITAL_TIME;
                    ground.removeProp();
                    IO.writeTo(getName() + Phrases.SEND_TO_H);
                    return;
                } else {
                    throw new AssertionError();
                }
            }
        }
        position = (position + step) % Phrases.GROUND_COUNT;
    }

    private void removePlayerFromPrePosition(RichMap richMap) {
        Ground ground = richMap.getGround(position);
        if (!(ground instanceof StartPoint)) {
            ground.removePlayer(this);
        }
    }

    private void addPlayerToCurPosition(RichMap richMap) {
        int position = getPosition();
        Ground ground = richMap.getGround(position);
        ground.addPlayer(this);
    }

    public void reachPlaceActions(RichMap richMap) {
        ReachPlaceAction placeAction = getActionType(richMap);
        placeAction.action();
    }

    private ReachPlaceAction getActionType(RichMap richMap){
        int position = getPosition();
        Ground ground = richMap.getGround(position);
        return ground.getActionType(this, ground, richMap);
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return role.getName();
    }

    public boolean buyLand(Ground ground) {
        boolean flag = true;
        Land land = (Land) ground;
        if (null != land.getOwner()) {
            flag = false;
        }
        land.setOwner(this);
        assets.addAssets(land);
        money -= land.getPrice();
        return flag;
    }

    public void upDateLand(Land land) {
        if (getName().equals(land.getOwner().getName())) {
            try {
                land.upDate();
            } catch (UpdateException e) {
                e.printStackTrace();
            }
        } else {
            IO.writeTo(Phrases.CANNOT_UPDATE_LAND_NOT_OWN);
        }
    }

    public void sellLand(Land land) {
        if (land.getOwner().equals(this)) {
            assets.lost(land);
            money += land.calculateValue();
            land.reSetting();
        }
    }

    public void addGiftCard(GiftCard giftCard) {
        if (giftCard.equals(GiftCard.BONUS_CARD)) {
            addMoney(giftCard.getValue());
        } else if (giftCard.equals(GiftCard.POINTS_CARD)) {
            addPoints(giftCard.getValue());
        } else {
            setFuShenTime(5);
        }
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return points;
    }


    public void setFuShenTime(int fuShenTime) {
        this.fuShenTime = fuShenTime;
    }

    public int getFuShenTimes() {
        return fuShenTime;
    }

    public void reduceFreePass() {
        if (fuShenTime > 0) {
            fuShenTime--;
        }
    }

    public void payToll(int toll) {
        this.money -= toll;
    }

    public void goPrison() {
        cancelTimes = Phrases.PRISON_TIME;
    }

    public boolean isBogged() {
        boolean flag;
        if (cancelTimes > 0) {
            flag = true;
        } else {
            flag = false;
        }
        cancelTimes--;
        return flag;
    }

    public void buyProp(Prop prop) {
        if (props.containsKey(prop)) {
            Integer value = props.get(prop);
            props.put(prop, value + 1);
        } else {
            props.put(prop, 1);
        }
        points -= prop.getPoints();
    }

    public void usePro(Prop prop, Ground ground) {
        ground.addProp(prop);
        props.put(prop, props.get(prop) - 1);
    }

    public Map<Prop, Integer> getProp() {
        return props;
    }

    public void sellProp(Prop prop) throws PropNotOwnException {
        if (props.containsKey(prop)) {
            points += prop.getPoints();
            props.put(prop, props.get(prop) - 1);
        } else {
            throw new PropNotOwnException();
        }
    }

    public void useRobot(RichMap richMap) throws PropNotOwnException {
        if (props.containsKey(Prop.ROBOT)) {
            for (int i = 1; i <= 10; i++) {
                int pos = (position + i) % Phrases.GROUND_COUNT;
                Ground ground = richMap.getGround(pos);
                if (ground.hasProp()) {
                    ground.removeProp();
                }
            }
            if (props.get(Prop.ROBOT) == 1) {
                props.remove(Prop.ROBOT);
            } else {
                props.put(Prop.ROBOT, props.get(Prop.ROBOT) - 1);
            }
            IO.writeTo(Phrases.CLEAR_BLOCK_OR_BOMB);
        } else {
            throw new PropNotOwnException();
        }

    }
}
