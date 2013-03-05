package com.jing.rich.action;

import com.jing.rich.tools.IO;
import com.jing.rich.Map;
import com.jing.rich.tools.Phrases;
import com.jing.rich.Player;
import com.jing.rich.exception.CommandNotFoundException;
import com.jing.rich.ground.Ground;
import com.jing.rich.ground.Hospital;
import com.jing.rich.ground.Land;
import com.jing.rich.ground.Prison;


public class LandAction extends AbstractReachPlaceAction {
    private Map map;

    public LandAction(Player player, Ground ground, Map map) {
        super(player, ground);
        this.map = map;
    }

    @Override
    public void action() {
        Land land = (Land) ground;
        Player owner = land.getOwner();
        if (null == owner) {
            parseBuyLandOption(land);
        } else if (owner.getName().equals(player.getName())) {
            parseUpDateLandOption(land);
        } else {
            PayTollToOwner(owner, land);
        }
    }

    private void parseUpDateLandOption(Land land) {
        IO.writeTo(Phrases.UPDATE_LAND_TIP + land.getPrice() + Phrases.UPDATE_UNIT);
        while (true) {
            String command = IO.readLine();
            if (command.equals(Phrases.YES)) {
                player.upDateLand(land);
                IO.writeTo(land.getNumber() + Phrases.UPDATE_LAND_SUCCESS + land.getName());
                return;
            } else if (command.equals(Phrases.NO)) {
                return;
            } else {
                IO.writeTo(Phrases.WRONG_COMMAND);
            }
        }
    }


    private void parseBuyLandOption(Land land) {
        IO.writeTo(Phrases.OPENSPACE_TOBUY + land.getPrice() + Phrases.OPENSPACE_TOBUY_UNIT);
        while (true) {
            String command = IO.readLine();
            if (command.equals(Phrases.YES)) {
                player.buyLand(land);
                IO.writeTo(Phrases.BUY_LAND_SUCCESS + ground.getNumber() + Phrases.BUY_LAND_SUCCESS_AFTER);
                return;
            } else if (command.equals(Phrases.NO)) {
                return;
            } else {
                IO.writeTo(Phrases.WRONG_COMMAND);
            }
        }
    }

    public int PayTollToOwner(Player owner, Land land) {
        int toll = land.getToll();
        IO.writeTo(Phrases.ROLL_TIP_PRE + owner.getRole().getName() + Phrases.ROLL_TIP + toll);
        if (map.getGround(owner.getPosition()) instanceof Hospital) {
            toll = 0;
            IO.writeTo(Phrases.OWNER_IN_H);
        } else if ((map.getGround(owner.getPosition()) instanceof Prison)) {
            toll = 0;
            IO.writeTo(Phrases.OWNER_IN_P);
        } else if (player.getFuShenTimes() > 0) {
            IO.writeTo(Phrases.FUSHEN_USE);
            toll = 0;
        }
        if (toll > 0) {
            IO.writeTo(player.getRole().getName() + Phrases.PAY_ROLL_TIP + toll + Phrases.MONEY_UNIT);
            IO.writeTo(owner.getRole().getName() + Phrases.GET_ROLL_TIP + toll + Phrases.MONEY_UNIT);
            player.payToll(toll);
            owner.addMoney(toll);
        }
        return toll;
    }

}
