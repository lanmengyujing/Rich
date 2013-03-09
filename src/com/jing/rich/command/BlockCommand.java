package com.jing.rich.command;

import com.jing.rich.RichMap;
import com.jing.rich.exception.*;
import com.jing.rich.tools.Phrases;
import com.jing.rich.Player;
import com.jing.rich.ground.Ground;
import com.jing.rich.tools.Prop;

public class BlockCommand implements Command {

    private int number;

    public BlockCommand(int number) {
        this.number = number;
    }

    @Override
    public void execute(RichMap richMap, Player player) throws GameException {
        if (number < -10 || number > 10) {
            throw new WrongNumberForStep();
        } else if (!(player.getProp().containsKey(Prop.ROAD_BLOCK))) {
            throw new PropNotOwnException();
        } else {
            int position = (player.getPosition() + number) % Phrases.GROUND_COUNT;
            Ground ground = richMap.getGround(position);
            if (ground.hasProp()) {
                throw new PropPositonException();
            }else if(ground.hasPlayer()){
                throw new PositionHasPlayerException();
            }
            player.usePro(Prop.ROAD_BLOCK, ground);
        }
    }
}
