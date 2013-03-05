package com.jing.rich.tools;

import com.jing.rich.Phrases;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-3
 * Time: 下午6:51
 * To change this template use File | Settings | File Templates.
 */
public enum GiftCard {
    BONUSCARD(Phrases.GIFT_BONUSCARD, 1, 2000),
    POINTSCARD(Phrases.GIFT_POINTSCARD, 2, 200),
    FUSHENCARD(Phrases.GIFT_FUSEHNCARD, 3, 5);

    private String name;
    private int code;
    private int value;

    private GiftCard(String name, int code, int value){
        this.name = name;
        this.code = code;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
