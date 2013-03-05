package com.jing.rich.command;

import com.jing.rich.Map;
import com.jing.rich.Player;
import com.jing.rich.exception.PropNotOwnException;


public class RobotCommand implements Command {
    @Override
    public void execute(Map map, Player player) throws PropNotOwnException {
        player.useRobot(map);
    }
}
