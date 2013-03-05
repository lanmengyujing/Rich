package com.jing.rich.ground;

import com.jing.rich.Phrases;
import com.jing.rich.Player;
import com.jing.rich.exception.UpdateException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-2-6
 * Time: 下午6:04
 * To change this template use File | Settings | File Templates.
 */
public class Land extends AbstractGround {
    private int level; //the rank of the house ,-1 means land has no owner
    private Player owner;
    private int price;

    public Land(int initPrice) {
        level = 0;
        price = initPrice;
    }

    @Override
    public String getSign() {
        String sign;
        switch (level) {
            case 0:
                sign = "0";
                break;
            case 1:
                sign = "1";
                break;
            case 2:
                sign = "2";
                break;
            case 3:
                sign = "3";
                break;
            default:
                throw new AssertionError();
        }
        return sign;
    }

    public int getLevel() {
        return level;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player player) {
        owner = player;
    }

    public int getPrice() {
        return price;
    }

    public int getToll() {
        return price * (level + 1) / 2;
    }

    public void upDate() throws UpdateException {
        if (level < 3) {
            ++level;
        } else {
            throw new UpdateException();
        }
    }

    /*!
        重置土地，变为空地
    */
    public int reSetting() {
        level = -1;
        owner = null;
        int value = calculateCost();
        return value;
    }

    private int calculateCost() {
        int cost = 0;
        if (level > -1) {
            cost = (price + level * price) * 2;
        }
        return cost;
    }

    public String toString() {
        String str = "Land";
        return str;
    }

    public String getName() {
        String name;
        switch (level){
            case 0:
                name = Phrases.OPENSPACE;
                break;
            case 1:
                name = Phrases.MAO_WU;
                break;
            case 2:
                name = Phrases.YANG_LOU;
                break;
            case 3:
                name = Phrases.MO_TIAN_LOU;
                break;
            default:
                throw new AssertionError();
        }
        return name;
    }
}
