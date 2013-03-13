package com.jing.rich;

import com.jing.rich.ground.Ground;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-13
 * Time: 下午9:48
 * To change this template use File | Settings | File Templates.
 */
public class NoPropState implements GroundState {
    @Override
    public boolean walk(Ground ground, Player player) {
        return true;
    }
}
