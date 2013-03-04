package com.jing.rich.action;

import com.jing.rich.IO;
import com.jing.rich.Phrases;
import com.jing.rich.Player;
import com.jing.rich.ground.Ground;
import com.jing.rich.ground.Mine;
import com.jing.rich.ground.Prison;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-3
 * Time: 下午10:35
 * To change this template use File | Settings | File Templates.
 */
public class MineAction extends AbstractReachPlaceAction {
    public MineAction(Player player, Ground ground) {
        super(player, ground);
    }

    @Override
    public void action() {
        Mine mine = (Mine)ground;
        int points = mine.getPoints();
        player.addPoints(points);
        IO.writeTo(Phrases.GET_POINTS + points );
    }
}
