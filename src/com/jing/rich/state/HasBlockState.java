package com.jing.rich.state;

import com.jing.rich.Player;
import com.jing.rich.ground.Ground;
import com.jing.rich.state.GroundState;
import com.jing.rich.tools.IO;
import com.jing.rich.tools.Phrases;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-13
 * Time: 下午9:49
 * To change this template use File | Settings | File Templates.
 */
public class HasBlockState implements GroundState {
    @Override
    public boolean walk(Ground ground, Player player) {
        ground.removeProp();
        IO.writeTo(player.getName() + Phrases.BE_BLOCK);
        return false;
    }
}
