package com.jing.rich;

import com.jing.rich.ground.*;
import com.jing.rich.tools.Phrases;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-2-6
 * Time: 下午6:16
 * To change this template use File | Settings | File Templates.
 */
public class RichMap {
    static private Ground[] landList;
    static private int index;
    static private RichMap richMap;

    private RichMap() {
    }

    public static RichMap getInstance() {
        index = 0;
        landList = new Ground[70];

        add(new StartPoint());

        for (int i = 0; i < 13; i++) {
            add(new Land(Phrases.priceList[0]));
        }

        add(new Hospital());

        for (int i = 0; i < 13; i++) {
            add(new Land(Phrases.priceList[0]));
        }
        add(new ToolHouse());

        for (int i = 0; i < 6; i++) {
            add(new Land(Phrases.priceList[1]));
        }

        add(new GiftHouse());

        for (int i = 0; i < 13; i++) {
            add(new Land(Phrases.priceList[2]));
        }

        add(new Prison());

        for (int i = 0; i < 13; i++) {
            add(new Land(Phrases.priceList[2]));
        }

        add(new MagicHouse());

        for (int i = 0; i < 6; i++) {
            add(new Mine(Phrases.pointsList[i]));
        }

        richMap = new RichMap();
        return richMap;
    }

    private static void add(Ground land) {
        land.setNumber(index);
        landList[index] = land;
        index++;
    }

    public Ground getGround(int index) {
        return landList[index];
    }

    public Ground[] getGroundList() {
        return landList;
    }
}
