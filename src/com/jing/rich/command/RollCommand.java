package com.jing.rich.command;

import com.jing.rich.*;
import com.jing.rich.tools.Dice;
import com.jing.rich.tools.IO;
import com.jing.rich.tools.Phrases;

public class RollCommand implements Command {

    @Override
    public void execute(RichMap richMap, Player player) {
        int step = Dice.roll();
        IO.writeTo(player.getRole().getName() + Phrases.MOVE + step + Phrases.MOVE_UNIT);
        player.move(step, richMap);
        player.reachPlaceActions(richMap);
    }
}
