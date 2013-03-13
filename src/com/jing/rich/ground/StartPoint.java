package com.jing.rich.ground;


import com.jing.rich.Player;
import com.jing.rich.RichMap;
import com.jing.rich.action.ReachPlaceAction;
import com.jing.rich.action.StartPointAction;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-2-6
 * Time: 下午7:22
 * To change this template use File | Settings | File Templates.
 */
public class StartPoint extends AbstractGround {
    @Override
    public String getSign() {
        return "S";
    }

    @Override
    public ReachPlaceAction getActionType(Player player, Ground ground, RichMap richMap) {
        return new StartPointAction(player, ground);
    }
}
