package com.jing.rich.action;

import com.jing.rich.Map;
import com.jing.rich.Player;
import com.jing.rich.ground.Ground;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-1
 * Time: 下午3:57
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractReachPlaceAction implements ReachPlaceAction {
    protected Player player;
    protected Ground ground;

    protected AbstractReachPlaceAction(Player player, Ground ground){
        this.player = player;
        this.ground = ground;
    }
    abstract public void action( );
}
