package com.jing.rich.ground;

import com.jing.rich.Player;
import com.jing.rich.RichMap;
import com.jing.rich.action.ReachPlaceAction;
import com.jing.rich.action.ToolHouseAction;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-2-6
 * Time: 下午7:28
 * To change this template use File | Settings | File Templates.
 */
public class ToolHouse extends AbstractGround {
    @Override
    public String getSign() {
        return "T";
    }

    @Override
    public ReachPlaceAction getActionType(Player player, Ground ground, RichMap richMap) {
        return new ToolHouseAction(player, ground);
    }
}
