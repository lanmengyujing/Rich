package com.jing.rich.tools;

import com.jing.rich.exception.PropNumberException;


public enum Prop {
    ROAD_BLOCK(Phrases.ROAD_BLOCK_NAME, 1, 50, Phrases.ROAD_BLOCK_SYMBOL),
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

    public static Prop getPropByCode(int code) throws PropNumberException {
        switch (code) {
            case 1:
                return ROAD_BLOCK;
            case 2:
                return  ROBOT;
            case 3:
                return  BOMB;
            default:
                throw new PropNumberException();
        }
    }

    public String getSymbol() {
        return symbol;
    }
}
