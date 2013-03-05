package com.jing.rich.command;

import com.jing.rich.IO;
import com.jing.rich.Map;
import com.jing.rich.Phrases;
import com.jing.rich.Player;
import com.jing.rich.exception.GameException;
import com.jing.rich.exception.NotOwnLandException;
import com.jing.rich.exception.NumberOfLandNotFoundException;
import com.jing.rich.ground.Land;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-1
 * Time: 下午4:35
 * To change this template use File | Settings | File Templates.
 */
public class SellCommand implements Command {
    private int number;

    public SellCommand(int number) {
        this.number = number;
    }

    @Override
    public void execute(Map map, Player player) throws GameException {
        if (number < 0 || number > Phrases.GROUND_COUNT) {
            throw new NumberOfLandNotFoundException();
        } else if (!(map.getGround(number) instanceof Land)) {
            throw new NumberOfLandNotFoundException();
        }
        Land land = (Land) map.getGround(number);
        sellLand(player, land);
    }

    private void sellLand(Player player, Land land) throws NotOwnLandException {
        Player owner = land.getOwner();
        if (owner != null && (owner.getName().equals(player.getName()))) {
            player.sellLand(land);
            IO.writeTo(number + Phrases.SOLD_TIP);
        } else {
            throw new NotOwnLandException();
        }
    }
}
