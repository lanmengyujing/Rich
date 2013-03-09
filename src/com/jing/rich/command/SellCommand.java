package com.jing.rich.command;

import com.jing.rich.RichMap;
import com.jing.rich.tools.IO;
import com.jing.rich.tools.Phrases;
import com.jing.rich.Player;
import com.jing.rich.exception.GameException;
import com.jing.rich.exception.NotOwnLandException;
import com.jing.rich.exception.NumberOfLandNotFoundException;
import com.jing.rich.ground.Land;


public class SellCommand implements Command {
    private int number;

    public SellCommand(int number) {
        this.number = number;
    }

    @Override
    public void execute(RichMap richMap, Player player) throws GameException {
        if (number < 0 || number > Phrases.GROUND_COUNT) {
            throw new NumberOfLandNotFoundException();
        } else if (!(richMap.getGround(number) instanceof Land)) {
            throw new NumberOfLandNotFoundException();
        }
        Land land = (Land) richMap.getGround(number);
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
