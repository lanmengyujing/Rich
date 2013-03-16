package com.jing.rich.command;

import com.jing.rich.Player;
import com.jing.rich.RichMap;
import com.jing.rich.exception.*;
import com.jing.rich.ground.Ground;
import com.jing.rich.tools.Phrases;
import com.jing.rich.tools.Prop;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-13
 * Time: 下午4:43
 * To change this template use File | Settings | File Templates.
 */
abstract class PutHinder {
    private int number;

    public PutHinder(int number) {
        this.number = number;
    }

    public void execute(RichMap richMap, Player player, Prop prop) throws GameException {
        if (number < -10 || number > 10) {
            throw new WrongNumberForStep();
        } else if (!(player.getProp().containsKey(prop))) {
            throw new PropNotOwnException();
        } else {
            int position = (player.getPosition() + number) % Phrases.GROUND_COUNT;
            Ground ground = richMap.getGround(position);
            if (ground.hasProp()) {
                throw new PropPositionException();
            }
            if (ground.hasPlayer()){
                throw new PositionHasPlayerException();
            }
            player.usePro(prop, ground);
        }
    }
}
