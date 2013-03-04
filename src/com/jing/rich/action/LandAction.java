package com.jing.rich.action;

import com.jing.rich.IO;
import com.jing.rich.Map;
import com.jing.rich.Phrases;
import com.jing.rich.Player;
import com.jing.rich.exception.CommandNotFoundException;
import com.jing.rich.ground.Ground;
import com.jing.rich.ground.Hospital;
import com.jing.rich.ground.Land;
import com.jing.rich.ground.Prison;
import sun.font.PhysicalFont;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-1
 * Time: 下午3:49
 * To change this template use File | Settings | File Templates.
 */
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
        if (null != owner) {
            PayTollToOwner(owner, land);
        } else {
            BuyOpenLandOption(land);
        }
    }

    public int PayTollToOwner(Player owner, Land land) {
        int toll = land.getToll();
        IO.writeTo(Phrases.ROLL_TIP_PRE + owner.getRole().getName() + Phrases.ROLL_TIP + toll);
        IO.newLine();
        if (map.getGround(owner.getPosition()) instanceof Hospital){
            toll = 0;
            IO.writeTo(Phrases.OWNER_IN_H);
        } else if( (map.getGround(owner.getPosition())instanceof Prison) ){
            toll = 0;
            IO.writeTo(Phrases.OWNER_IN_P);
        } else if (player.getFuShenTimes() > 0) {
            IO.writeTo(Phrases.FUSHEN_TIP);
            toll = 0;
        }
        if (toll > 0) {
            IO.writeTo(player.getRole().getName() + Phrases.PAY_ROLL_TIP + toll + Phrases.MONEY_UNIT);
            IO.newLine();
            IO.writeTo(owner.getRole().getName() + Phrases.GET_ROLL_TIP + toll + Phrases.MONEY_UNIT);
            IO.newLine();
            player.payToll(toll);
            owner.addMoney(toll);
        }
        return toll;
    }

    private void BuyOpenLandOption(Land land) {
        IO.writeTo(Phrases.OPENSPACE_TOBUY + land.getPrice() + Phrases.OPENSPACE_TOBUY_UNIT);
        while (true) {
            String command = IO.readLine();
            try {
                parseBuyLandOption(command);
                return;
            } catch (CommandNotFoundException e) {
                e.getMessage();
            }
        }
    }

    private void parseBuyLandOption(String command) throws CommandNotFoundException {
        if (command.equals(Phrases.YES)) {
            player.buyLand(ground);
        } else if (command.equals(Phrases.NO)) {
            return;
        } else {
            throw new CommandNotFoundException();
        }
    }

}
