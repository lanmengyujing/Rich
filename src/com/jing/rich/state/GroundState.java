package com.jing.rich.state;

import com.jing.rich.Player;
import com.jing.rich.ground.Ground;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-13
 * Time: 下午9:47
 * To change this template use File | Settings | File Templates.
 */
public interface GroundState {
    boolean walk(Ground ground, Player player);
}
