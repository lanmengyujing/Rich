package com.jing.rich.command;

import com.jing.rich.RichMap;
import com.jing.rich.Player;
import com.jing.rich.exception.PropNotOwnException;


public class RobotCommand implements Command {
    @Override
    public void execute(RichMap richMap, Player player) throws PropNotOwnException {
        player.useRobot(richMap);
    }
}
