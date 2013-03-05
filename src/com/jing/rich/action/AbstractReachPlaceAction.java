package com.jing.rich.action;

import com.jing.rich.Player;
import com.jing.rich.ground.Ground;

public abstract class AbstractReachPlaceAction implements ReachPlaceAction {
    protected Player player;
    protected Ground ground;

    protected AbstractReachPlaceAction(Player player, Ground ground) {
        this.player = player;
        this.ground = ground;
    }

    abstract public void action();
}
