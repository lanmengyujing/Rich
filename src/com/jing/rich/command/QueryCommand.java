package com.jing.rich.command;

import com.jing.rich.*;
import com.jing.rich.ground.Land;
import com.jing.rich.tools.Assets;
import com.jing.rich.tools.IO;
import com.jing.rich.tools.Phrases;
import com.jing.rich.tools.Prop;

import java.util.Map;


public class QueryCommand implements Command {
    @Override
    public void execute(RichMap richMap, Player player) {
        queryMoney(player);
        queryPoints(player);
        queryAssets(player);
        queryProp(player);
    }

    private void queryProp(Player player) {
        Map<Prop, Integer> props = player.getProp();
        for (Map.Entry<Prop, Integer> entry : props.entrySet()) {
            System.out.print(entry.getKey().getName() + " " + entry.getValue() + Phrases.PROP_UNIT);
        }
        IO.newLine();
    }

    private void queryMoney(Player player) {
        int money = player.getMoney();
        IO.writeTo(Phrases.MONEY + money + Phrases.MONEY_UNIT);
    }

    private void queryPoints(Player player) {
        int points = player.getPoints();
        IO.writeTo(Phrases.POINTS + points + Phrases.POINT_UNIT);
    }

    private void queryAssets(Player player) {
        Assets assets = player.getAssets();
        int[] landCount = getLandCount(assets);
        IO.writeTo(Phrases.ASSETS + Phrases.OPENSPACE + landCount[0] + Phrases.ASSETS_UNIT +
                Phrases.MAO_WU + landCount[1] + Phrases.ASSETS_UNIT +
                Phrases.YANG_LOU + landCount[2] + Phrases.ASSETS_UNIT +
                Phrases.MO_TIAN_LOU + landCount[3] + Phrases.ASSETS_UNIT);

    }

    private int[] getLandCount(Assets assets) {
        int openSpace = 0;
        int maoWu = 0;
        int yangLou = 0;
        int moTianLou = 0;
        for (Land land : assets.getAssetsList()) {
            switch (land.getLevel()) {
                case OPEN_SPACE:
                    openSpace++;
                    break;
                case MAO_WU:
                    maoWu++;
                    break;
                case YANG_FANG:
                    yangLou++;
                    break;
                case MO_TIAN_LOU:
                    moTianLou++;
                    break;
                default:
                    throw new AssertionError();
            }
        }
        int[] count = {openSpace, maoWu, yangLou, moTianLou};
        return count;
    }
}
