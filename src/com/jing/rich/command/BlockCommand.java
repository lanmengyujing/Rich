package com.jing.rich.command;

import com.jing.rich.Map;
import com.jing.rich.Player;
import com.jing.rich.exception.GameException;
import com.jing.rich.exception.PropNotOwnException;
import com.jing.rich.exception.WrongNumberForStep;
import com.jing.rich.ground.Ground;
import com.jing.rich.tools.Prop;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-1
 * Time: 下午4:33
 * To change this template use File | Settings | File Templates.
 */
public class BlockCommand implements Command {

    private int number;

    public BlockCommand(int number) {
        this.number = number;
    }

    @Override
    public void execute(Map map, Player player) throws GameException{
        if(number < -10 || number > 10){
            throw new WrongNumberForStep();
        } else if (!(player.getProp().contains(Prop.ROAD_BLOCK))){
            throw new PropNotOwnException();
        } else {
            Ground ground = map.getGround(number);
            player.usePro(Prop.ROAD_BLOCK，ground);
        }


    }
}
