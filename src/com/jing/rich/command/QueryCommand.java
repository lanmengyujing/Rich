package com.jing.rich.command;

import com.jing.rich.*;
import com.jing.rich.ground.Land;
import com.jing.rich.tools.Prop;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-1
 * Time: 下午4:35
 * To change this template use File | Settings | File Templates.
 */
public class QueryCommand implements Command {


    @Override
    public void execute(Map map, Player player) {
        int money = player.getMoney();
        int points = player.getPoints();
        Assets assets = player.getAssets();
        int[] landCount = getLandCount(assets);
        List<Prop> propList = player.getProp();
        int[] propCount = getPropCount(propList);
        IO.writeTo(Phrases.MONEY + money + Phrases.MONEY_UNIT);
        IO.writeTo(Phrases.POINTS + points + Phrases.POINT_UNIT);
        IO.writeTo(Phrases.ASSETS + Phrases.OPENSPACE + landCount[0] + Phrases.ASSETS_UNIT +
                    Phrases.MAO_WU + landCount[1] + Phrases.ASSETS_UNIT +
                    Phrases.YANG_LOU + landCount[2] + Phrases.ASSETS_UNIT +
                     Phrases.MO_TIAN_LOU + landCount[3] + Phrases.ASSETS_UNIT);
        IO.writeTo(Phrases.PROP + Phrases.ROAD_BLOCK_NAME + propCount[0] + Phrases.PROP_UNIT +
                Phrases.ROBOT_NAME + propCount[1]  + Phrases.PROP_UNIT  +
                Phrases.BOMB_NAME + propCount[2]  + Phrases.PROP_UNIT );
    }

    private int[] getLandCount(Assets assets) {
        int openSpace = 0;
        int maoWu = 0;
        int yangLou = 0;
        int moTianLou = 0;
        for(Land land: assets.getAssetsList()){
            switch (land.getLevel()){
                case 0:
                    openSpace++;
                    break;
                case 1:
                    maoWu++;
                    break;
                case 2:
                    yangLou++;
                    break;
                case 3:
                    moTianLou++;
                    break;
                default:
                    throw new AssertionError();
            }
        }
        int[] count = {openSpace, maoWu, yangLou, moTianLou};
        return count;
    }

    private int[] getPropCount(List<Prop> propList) {
        int roadBlock = 0;
        int robot = 0;
        int bomb = 0;
        for(Prop prop: propList){
            switch (prop.getCode()){
                case 1:
                    roadBlock++;
                    break;
                case 2:
                    robot++;
                    break;
                case 3:
                    bomb++;
                    break;
                default:
                    throw new AssertionError();
            }
        }
        int[] count = {roadBlock, robot,bomb};
        return count;

    }


}
