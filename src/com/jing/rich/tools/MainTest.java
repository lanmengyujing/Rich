package com.jing.rich.tools;

import com.jing.rich.*;
import com.jing.rich.command.Command;
import com.jing.rich.command.SellCommand;
import com.jing.rich.ground.Ground;
import com.jing.rich.ground.Land;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-4
 * Time: 下午8:19
 * To change this template use File | Settings | File Templates.
 */
public class MainTest {
    public static void main(String[] args){
        Game game = new Game();
        Map map = Map.getInstance();
        Player player = new Player(0, 1000, Role.aTuBo, new Assets());
        player.addPoints(100);
        /*player.move(35,map);
        player.reachPlaceActions(map);
        */
        player.move(6, map);
        player.reachPlaceActions(map);
        player.move(70, map);
        player.reachPlaceActions(map);
        /*player.move(14,map);
        player.reachPlaceActions(map);
        Player jinBei = new Player(0, 1000,Role.jinBeiBei, new Assets());
        jinBei.move(7,map);
        jinBei.reachPlaceActions(map);*/
        //Ground ground = map.getGround(6);
        //Player p = ground.getCurPlayer();
        //IO.writeTo(p.getName());
        //Command command = new SellCommand(6);
        //command.execute(map, player);
        game.startAction(player,map);
    }
}
