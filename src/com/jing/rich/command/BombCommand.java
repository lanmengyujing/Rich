package com.jing.rich.command;

import com.jing.rich.RichMap;
import com.jing.rich.Player;
import com.jing.rich.exception.GameException;
import com.jing.rich.tools.Prop;

public class BombCommand extends PutHinder implements Command {
    public BombCommand(int number) {
        super(number);
    }

    @Override
    public void execute(RichMap richMap, Player player) throws GameException {
        super.execute(richMap, player, Prop.BOMB);
    }
}
