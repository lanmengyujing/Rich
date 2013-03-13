package com.jing.rich.action.reachLandAction;

import com.jing.rich.Player;
import com.jing.rich.ground.Land;
import com.jing.rich.tools.IO;
import com.jing.rich.tools.Phrases;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-3-13
 * Time: 上午10:59
 * To change this template use File | Settings | File Templates.
 */
public class BuyLand extends LandActionBehavior {
    @Override
    void showTips(Land land, Player player) {
        IO.writeTo(Phrases.OPENSPACE_TOBUY + land.getPrice() + Phrases.OPENSPACE_TOBUY_UNIT);
    }

    @Override
    void dealWithLand(Land land, Player player) {
        player.buyLand(land);
        IO.writeTo(Phrases.BUY_LAND_SUCCESS + land.getNumber() + Phrases.BUY_LAND_SUCCESS_AFTER);
    }


}
