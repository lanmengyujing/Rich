package com.jing.rich;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-2
 * Time: 下午9:59
 * To change this template use File | Settings | File Templates.
 */
public class Role {
    private String name;
    private String symbol;

    private Role(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public static Role qianFuRen = new Role(Phrases.QIANFUREN, Phrases.QIANFUREN_CODE);
    public static Role aTuBo = new Role(Phrases.ATUBO, Phrases.ATUBO_CODE);
    public static Role sunXiaoMei = new Role(Phrases.SUNXIAOMEI, Phrases.SUNXIAOMEI_CODE);
    public static Role jinBeiBei = new Role(Phrases.JINBEIBEI, Phrases.JINBEIBEI_CODE);

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
}
