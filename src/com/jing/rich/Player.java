package com.jing.rich;

import com.jing.rich.action.*;
import com.jing.rich.exception.UpdateException;
import com.jing.rich.ground.*;
import com.jing.rich.tools.GiftCard;
import com.jing.rich.tools.Prop;

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

    public void move(int step, Map map) {
        removePlayerFromPrePosition(map);
        position = (position + step) % Phrases.GROUND_COUNT;
        addPlayerToCurPosition(map);
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
        }else if(ground instanceof Mine){
            placeAction = new MineAction(this, ground);
        }
        if (null != placeAction) {
            placeAction.action();
        }
        if (fuShenTime > 0) {
            fuShenTime--;
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
            IO.newLine();
        }
    }

    public void sellLand(Land land) {
       if (land.getOwner().equals(this)) {
            assets.lost(land);
            int soldMoney = land.reSetting();
            money += soldMoney;
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

    public void payToll(int toll) {
        this.money -= toll;
    }

    public void goPrison() {
        cancelTimes = 2;
    }

    public boolean isBogged(){
        boolean flag;
        if(cancelTimes > 0){
            flag = true;
        }else {
            flag = false;
        }
        cancelTimes--;
        return flag;
    }

    public void addProp(Prop prop) {
        propList.add(prop);
        points -= prop.getPoints();
    }

    public void usePro(Prop prop){

    }

    public List<Prop> getProp() {
        return propList;
    }


}
