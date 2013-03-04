package com.jing.rich.command;

import com.jing.rich.*;
import com.jing.rich.ground.Ground;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-1
 * Time: 下午4:31
 * To change this template use File | Settings | File Templates.
 */
public class RollCommand implements Command {

    @Override
    public void execute(Map map,Player player) {
        int step = Dice.roll();
        IO.writeTo(player.getRole().getName()+" forward "+step);
        IO.newLine();
        player.move(step,map);
        player.reachPlaceActions(map);
    }
}
