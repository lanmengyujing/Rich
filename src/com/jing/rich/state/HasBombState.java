package com.jing.rich.state;

import com.jing.rich.Player;
import com.jing.rich.ground.Ground;
import com.jing.rich.tools.IO;
import com.jing.rich.tools.Phrases;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-13
 * Time: 下午9:48
 * To change this template use File | Settings | File Templates.
 */
public class HasBombState implements GroundState {
    @Override
    public boolean walk(Ground ground, Player player) {
        int position = Phrases.HOSPITAL_POS;
        player.setPosition(position);
        int cancelTimes = Phrases.IN_HOSPITAL_TIME;
        player.setCancelTimes(cancelTimes);
        ground.removeProp();
        IO.writeTo(player.getName() + Phrases.SEND_TO_H);
        return false;
    }
}
