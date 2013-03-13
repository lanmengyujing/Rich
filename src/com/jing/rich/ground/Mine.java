package com.jing.rich.ground;


import com.jing.rich.Player;
import com.jing.rich.RichMap;
import com.jing.rich.action.MineAction;
import com.jing.rich.action.PrisonAction;
import com.jing.rich.action.ReachPlaceAction;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-2-6
 * Time: 下午7:38
 * To change this template use File | Settings | File Templates.
 */
public class Mine extends AbstractGround {
    private int points;

    public Mine(int points) {
        this.points = points;
    }

    @Override
    public String getSign() {
        return "$";
    }

    @Override
    public ReachPlaceAction getActionType(Player player, Ground ground, RichMap richMap) {
        return new MineAction(player, ground);
    }

    public int getPoints() {
        return points;
    }
}
