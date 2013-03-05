package com.jing.rich.ground;


/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-2-6
 * Time: 下午7:38
 * To change this template use File | Settings | File Templates.
 */
public class Mine extends AbstractGround {
    private int points;

    public Mine(int points) {
        this.points = points;
    }

    @Override
    public String getSign() {
        return "$";
    }

    public int getPoints() {
        return points;
    }
}
