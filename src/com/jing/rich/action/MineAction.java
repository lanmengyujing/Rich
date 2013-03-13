package com.jing.rich.action;

import com.jing.rich.tools.IO;
import com.jing.rich.tools.Phrases;
import com.jing.rich.Player;
import com.jing.rich.ground.Ground;
import com.jing.rich.ground.Mine;

public class MineAction extends AbstractReachPlaceAction {
    public MineAction(Player player, Ground ground) {
        super(player, ground);
    }

    @Override
    public void action() {
        Mine mine = (Mine) ground;
        int points = mine.getPoints();
        player.addPoints(points);
        IO.writeTo(Phrases.GET_POINTS + points);
    }

}
