package com.jing.rich.tools;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-2-28
 * Time: 下午4:25
 * To change this template use File | Settings | File Templates.
 */
public class Prop {
    private int code;
    private int points;
    private String symbol;

    public static Prop RoadBlock = new Prop(1, 50 ,"#");
    public static Prop Robot = new Prop(2, 30 , " ");
    public static Prop Bomb = new Prop(3, 50, "@");

    private Prop(int code, int points, String symbol) {
        this.code = code;
        this.points = points;
        this.symbol = symbol;
    }
}
