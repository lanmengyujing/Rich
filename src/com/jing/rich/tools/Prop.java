package com.jing.rich.tools;

import com.jing.rich.Phrases;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-2-28
 * Time: 下午4:25
 * To change this template use File | Settings | File Templates.
 */
public enum Prop {
    ROAD_BLOCK(Phrases.ROAD_NAME, 1, 50, Phrases.ROAD_SYMBOL),
    ROBOT(Phrases.ROBOT_NAME, 2, 30, Phrases.ROBOT_SYMBOL),
    BOMB(Phrases.BOMB_NAME, 3, 50, Phrases.BOMB_SYMBOL);

    private String name;
    private int code;
    private int points;
    private String symbol;


    private Prop(String name, int code, int points, String symbol) {
        this.name = name;
        this.code = code;
        this.points = points;
        this.symbol = symbol;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }
}
