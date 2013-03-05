package com.jing.rich.command;

import com.jing.rich.Map;
import com.jing.rich.Player;
import com.jing.rich.exception.GameException;


public interface Command {
    public void execute(Map map, Player player) throws GameException;
}
