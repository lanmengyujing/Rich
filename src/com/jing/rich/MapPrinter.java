package com.jing.rich;

import com.jing.rich.ground.Ground;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-2-08
 * Time: 下午5:22
 * To change this template use File | Settings | File Templates.
 */
public class MapPrinter {

    public static void printMap(Map map) {

        int index = 0;
        int backIndex = 69;
        Ground[] groundList = map.getGroundList();
        for (int i = 0; i < 29; i++) {
            outPut(groundList[index]);
            index++;
        }
        newLine();
        for (int line = 0; line < 6; line++) {
            outPut(groundList[backIndex]);
            backIndex--;
            for (int i = 0; i < 27; i++) {
                outPut(null);
            }
            outPut(groundList[index]);
            index++;
            newLine();
        }
        for (int i = 0; i < 29; i++) {
            outPut(groundList[backIndex]);
            backIndex--;
        }
        newLine();
    }

    private static void newLine() {
        System.out.print(System.getProperty("line.separator"));
    }

    private static void outPut(Ground ground) {
        String sign;
        if (null == ground) {
            sign = " ";
        } else {
            sign = getSign(ground);
        }
        System.out.print(sign);
    }

    private static String getSign(Ground ground) {
        String sign;
        Player player = ground.getCurPlayer();
        if (null != player) {
            sign = player.getRole().getSymbol();
        } else if (ground.hasProp()) {
            sign = ground.getProp().getSymbol();
        } else {
            sign = ground.getSign();
        }
        return sign;
    }
}
