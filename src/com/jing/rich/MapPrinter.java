package com.jing.rich;

import com.jing.rich.ground.Ground;
import com.jing.rich.ground.Land;
import com.jing.rich.tools.Phrases;
import enigma.console.Console;
import enigma.console.TextAttributes;
import enigma.core.Enigma;

import java.awt.*;

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
            setOutPutColor(ground);
        }
        System.out.print(sign);
        Game.console.setTextAttributes(new TextAttributes(Game.defaultForeground, Game.defaultBackground));
    }

    private static void setOutPutColor(Ground ground) {
        if (ground.hasPlayer()) {
            Color foreground = ground.getCurPlayer().getRole().getColor();
            setColor(foreground);
        } else if (ground instanceof Land) {
            if (((Land) ground).getOwner() != null) {
                Color foreground = ((Land) ground).getOwner().getRole().getColor();
                setColor(foreground);
            }
        }
    }

    private static void setColor(Color foreground) {
        TextAttributes attrs = new TextAttributes(foreground, Game.defaultBackground);
        Game.console.setTextAttributes(attrs);
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
