package com.jing.rich;


import com.jing.rich.tools.Phrases;

import java.awt.*;


public enum Role {
    QIAN_FU_REN(Phrases.QIANFUREN, Phrases.QIANFUREN_CODE, Color.cyan),
    A_TU_BO(Phrases.ATUBO, Phrases.ATUBO_CODE, Color.yellow),
    SUN_XIAO_MEI(Phrases.SUNXIAOMEI, Phrases.SUNXIAOMEI_CODE, Color.red),
    JIN_BEI_BEI(Phrases.JINBEIBEI, Phrases.JINBEIBEI_CODE, Color.green);

    private String name;
    private String symbol;
    private Color color;

    private Role(String name, String symbol, Color color) {
        this.name = name;
        this.symbol = symbol;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public Color getColor() {
        return color;
    }
}
