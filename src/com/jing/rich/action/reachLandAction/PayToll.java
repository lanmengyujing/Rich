package com.jing.rich.action.reachLandAction;

import com.jing.rich.Player;
import com.jing.rich.action.reachLandAction.LandActionBehavior;
import com.jing.rich.ground.Ground;
import com.jing.rich.ground.Hospital;
import com.jing.rich.ground.Land;
import com.jing.rich.ground.Prison;
import com.jing.rich.tools.IO;
import com.jing.rich.tools.Phrases;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-3-13
 * Time: 上午10:59
 * To change this template use File | Settings | File Templates.
 */
public class PayToll extends LandActionBehavior {
    private Player owner;
    private Ground ownerPlace;
    private boolean hasToPay = true;

    public PayToll(Player owner, Ground ownerPlace) {
        this.owner = owner;
        this.ownerPlace = ownerPlace;
    }

    @Override
    void showTips(Land land, Player player) {
        int toll = land.getToll();
        IO.writeTo(Phrases.ROLL_TIP_PRE + owner.getRole().getName() + Phrases.ROLL_TIP + toll);
        if (ownerPlace instanceof Hospital) {
            IO.writeTo(Phrases.OWNER_IN_H);
            hasToPay = false;
        } else if ((ownerPlace instanceof Prison)) {
            IO.writeTo(Phrases.OWNER_IN_P);
            hasToPay = false;
        } else if (player.getFuShenTimes() > 0) {
            IO.writeTo(Phrases.FUSHEN_USE);
            hasToPay = false;
        } else {
            hasToPay = true;
        }

    }

    @Override
    void dealWithLand(Land land, Player player) {
        if (hasToPay) {
            int toll = land.getToll();
            player.payToll(toll);
            owner.addMoney(toll);
            IO.writeTo(player.getName()+ Phrases.PAY_ROLL_TIP + toll);
            IO.writeTo(owner.getName()+ Phrases.GET_ROLL_TIP + toll);
        }
    }

    @Override
    public boolean isInPayTollState() {
        return true;
    }

}
