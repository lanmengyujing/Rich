package com.jing.rich.tools;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-13
 * Time: 下午4:56
 * To change this template use File | Settings | File Templates.
 */
public enum Level {
    OPEN_SPACE(0, Phrases.OPENSPACE),
    MAO_WU(1, Phrases.MAO_WU),
    YANG_FANG(2, Phrases.YANG_LOU),
    MO_TIAN_LOU(3, Phrases.MO_TIAN_LOU);

    private int code;
    private String name;

    Level(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public Level nextLevel() {
        switch (code){
            case 0:
                return MAO_WU;
            case 1:
                return YANG_FANG;
            case 2:
                return MO_TIAN_LOU;
            default:
                throw new AssertionError();
        }

    }

    public String getName() {
        return name;
    }
}
