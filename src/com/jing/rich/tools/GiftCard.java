package com.jing.rich.tools;


public enum GiftCard {
    BONUS_CARD(Phrases.GIFT_BONUSCARD, 1, 2000),
    POINTS_CARD(Phrases.GIFT_POINTSCARD, 2, 200),
    FUSHEN_CARD(Phrases.GIFT_FUSEHNCARD, 3, 5);

    private String name;
    private int code;
    private int value;

    private GiftCard(String name, int code, int value) {
        this.name = name;
        this.code = code;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
