package com.jing.rich;

import com.jing.rich.action.*;
import com.jing.rich.exception.PropNotOwnException;
import com.jing.rich.exception.UpdateException;
import com.jing.rich.ground.*;
import com.jing.rich.tools.*;

import java.util.ArrayList;
import java.util.List;

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
    private List<Prop> propList = new ArrayList<Prop>();

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
            propList = null;
        }
        return flag;
    }

    public void move(int step, Map map) {
        removePlayerFromPrePosition(map);
        walkToFront(step, map);
        addPlayerToCurPosition(map);
    }

    private void walkToFront(int step, Map map) {
        int pos;
        for (int i = 1; i <= step; i++) {
            pos = (position + i) % Phrases.GROUND_COUNT;
            Ground ground = map.getGround(pos);
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

    private void addPlayerToCurPosition(Map map) {
        int position = getPosition();
        Ground ground = map.getGround(position);
        ground.addPlayer(this);
    }

    private void removePlayerFromPrePosition(Map map) {
        Ground ground = map.getGround(position);
        if (!(ground instanceof StartPoint)) {
            ground.removePlayer(this);
        }
    }

    public void reachPlaceActions(Map map) {
        int position = getPosition();
        Ground ground = map.getGround(position);

        ReachPlaceAction placeAction = null;
        if (ground instanceof Land) {
            placeAction = new LandAction(this, ground, map);
        } else if (ground instanceof GiftHouse) {
            placeAction = new GiftHouseAction(this, ground);
        } else if (ground instanceof Hospital) {
            placeAction = new HospitalAction(this, ground);
        } else if (ground instanceof MagicHouse) {
            placeAction = new MagicHouseAction(this, ground);
        } else if (ground instanceof ToolHouse) {
            placeAction = new ToolHouseAction(this, ground);
        } else if (ground instanceof Prison) {
            placeAction = new PrisonAction(this, ground);
        } else if (ground instanceof StartPoint) {
            placeAction = new StartPointAction(this, ground);
        } else if (ground instanceof Mine) {
            placeAction = new MineAction(this, ground);
        }
        if (null != placeAction) {
            placeAction.action();
        }
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
        if (giftCard.equals(GiftCard.BONUSCARD)) {
            addMoney(giftCard.getValue());
        } else if (giftCard.equals(GiftCard.POINTSCARD)) {
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
        cancelTimes = 2;
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
        propList.add(prop);
        points -= prop.getPoints();
    }

    public void usePro(Prop prop, Ground ground) {
        ground.addProp(prop);
        propList.remove(prop);
    }

    public List<Prop> getProp() {
        return propList;
    }

    public void sellProp(Prop prop) throws PropNotOwnException {
        if (propList.contains(prop)) {
            points += prop.getPoints();
            propList.remove(prop);
        } else {
            throw new PropNotOwnException();
        }
    }

    public void useRobot(Map map) throws PropNotOwnException {
        if (propList.contains(Prop.ROBOT)) {
            for (int i = 1; i <= 10; i++) {
                int pos = (position + i) % Phrases.GROUND_COUNT;
                Ground ground = map.getGround(pos);
                if (ground.hasProp()) {
                    ground.removeProp();
                }
            }
            propList.remove(Prop.ROBOT);
            IO.writeTo(Phrases.CLEAR_BLOCK_OR_BOMB);
        } else {
            throw new PropNotOwnException();
        }

    }
}
