package com.jing.rich.command;

import com.jing.rich.RichMap;
import com.jing.rich.exception.*;
import com.jing.rich.Player;
import com.jing.rich.tools.Prop;

public class BlockCommand extends UseHinder implements Command {
    public BlockCommand(int number) {
        super(number);
    }

    @Override
    public void execute(RichMap richMap, Player player) throws GameException {
        super.execute(richMap, player, Prop.ROAD_BLOCK);
    }
}
