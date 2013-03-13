package com.jing.rich.ground;

import com.jing.rich.RichMap;
import com.jing.rich.action.LandAction;
import com.jing.rich.action.ReachPlaceAction;
import com.jing.rich.tools.Level;
import com.jing.rich.tools.Phrases;
import com.jing.rich.Player;
import com.jing.rich.exception.UpdateException;
import com.jing.rich.tools.Prop;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-2-6
 * Time: 下午6:04
 * To change this template use File | Settings | File Templates.
 */
public class Land extends AbstractGround {
    private Level level;
    private Player owner;
    private int price;

    public Land(int initPrice) {
        level = Level.OPEN_SPACE;
        price = initPrice;
    }

    @Override
    public String getSign() {
        String sign;
        switch (level) {
            case OPEN_SPACE:
                sign = "0";
                break;
            case MAO_WU:
                sign = "1";
                break;
            case YANG_FANG:
                sign = "2";
                break;
            case MO_TIAN_LOU:
                sign = "3";
                break;
            default:
                throw new AssertionError();
        }
        return sign;
    }

    @Override
    public ReachPlaceAction getActionType(Player player, Ground ground, RichMap richMap) {
        return new LandAction(player, ground, richMap);
    }

    public Level getLevel() {
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
        return price * (level.getCode() + 1) / 2;
    }

    public void upDate() throws UpdateException {
        if (!level.equals(Level.MO_TIAN_LOU)) {
            level = level.nextLevel();
        } else {
            throw new UpdateException();
        }
    }

    /*!
        重置土地，变为空地
    */
    public void reSetting() {
        level = Level.OPEN_SPACE;
        owner = null;
    }

    public int calculateValue() {
        return (price + level.getCode() * price) * 2;
    }

    public String toString() {
        return  "Land";
    }

    public String getName() {
        return level.getName();
    }

}
