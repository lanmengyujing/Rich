package com.jing.rich.action.reachLandAction;

import com.jing.rich.Player;
import com.jing.rich.ground.Land;
import com.jing.rich.tools.IO;
import com.jing.rich.tools.Level;
import com.jing.rich.tools.Phrases;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-3-13
 * Time: 上午10:57
 * To change this template use File | Settings | File Templates.
 */
public class UpdateLand extends LandActionBehavior {
    private boolean canUpdate;

    @Override
    void showTips(Land land, Player player) {
        if (land.getLevel().equals(Level.MO_TIAN_LOU)) {
            canUpdate = false;
            return;
        }
        IO.writeTo(Phrases.UPDATE_LAND_TIP + land.getPrice() + Phrases.UPDATE_UNIT);
    }

    @Override
    void dealWithLand(Land land, Player player) {
        if (canUpdate) {
            player.upDateLand(land);
            IO.writeTo(land.getNumber() + Phrases.UPDATE_LAND_SUCCESS + land.getName());
        }
    }

}
