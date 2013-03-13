package com.jing.rich.ground;

import com.jing.rich.Player;
import com.jing.rich.RichMap;
import com.jing.rich.action.MagicHouseAction;
import com.jing.rich.action.ReachPlaceAction;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-2-6
 * Time: 下午7:30
 * To change this template use File | Settings | File Templates.
 */
public class MagicHouse extends AbstractGround {
    @Override
    public String getSign() {
        return "M";
    }

    @Override
    public ReachPlaceAction getActionType(Player player, Ground ground, RichMap richMap) {
        return new MagicHouseAction(player, ground);
    }
}
