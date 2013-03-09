package com.jing.rich.command;

import com.jing.rich.RichMap;
import com.jing.rich.Player;
import com.jing.rich.exception.GameException;


public interface Command {
    public void execute(RichMap richMap, Player player) throws GameException;
}
