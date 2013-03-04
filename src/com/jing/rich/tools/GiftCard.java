package com.jing.rich.tools;

import com.jing.rich.Phrases;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-3
 * Time: 下午6:51
 * To change this template use File | Settings | File Templates.
 */
public class GiftCard {
    private String name;
    private int value;

    public static GiftCard BonusCard = new GiftCard(Phrases.BONUSCARD,  2000);
    public static GiftCard PointsCard = new GiftCard(Phrases.POINTSCARD,  200);
    public static GiftCard FuShenCard = new GiftCard(Phrases.FUSEHNCARD,  5);

    private GiftCard(String name, int value){
        this.name = name;
        this.value = value;
    }

    public String getName(){
        return name;
    }

    public int getValue() {
        return value;
    }
}
