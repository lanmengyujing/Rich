package com.jing.rich.ground;

import com.jing.rich.Player;
import com.jing.rich.RichMap;
import com.jing.rich.action.PrisonAction;
import com.jing.rich.action.ReachPlaceAction;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-2-6
 * Time: 下午7:31
 * To change this template use File | Settings | File Templates.
 */
public class Prison extends AbstractGround {
    @Override
    public String getSign() {
        return "P";
    }

    @Override
    public ReachPlaceAction getActionType(Player player, Ground ground, RichMap richMap) {
        return new PrisonAction(player, ground);
    }
}
