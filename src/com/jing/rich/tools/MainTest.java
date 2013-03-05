package com.jing.rich.tools;

import com.jing.rich.*;
import com.jing.rich.command.Command;
import com.jing.rich.command.SellCommand;
import com.jing.rich.exception.GameException;
import com.jing.rich.ground.Ground;
import com.jing.rich.ground.Land;

import java.io.Console;

public class MainTest {
    public static void main(String[] args) {
        Game game = new Game();
        Map map = Map.getInstance();
        Player player = new Player(0, 1000, Role.aTuBo, new Assets());
        player.addPoints(1000);
        player.move(6, map);
        player.reachPlaceActions(map);
        player.move(70, map);
        player.reachPlaceActions(map);
        player.move(22, map);
        player.reachPlaceActions(map);
        MapPrinter.printMap(map);
        //player.move(14,map);
        //player.reachPlaceActions(map);
        Player jinBei = new Player(0, 1000,Role.jinBeiBei, new Assets());
        jinBei.move(29,map);
        jinBei.reachPlaceActions(map);
        //Ground ground = map.getGround(6);
        //Player p = ground.getCurPlayer();
        //IO.writeTo(p.getName());
        //Command command = new SellCommand(6);
        //command.execute(map, player);
        MapPrinter.printMap(map);
        game.startAction(player,map);
        MapPrinter.printMap(map);
        //jinBei.move(5,map);
        game.startAction(jinBei,map);
        MapPrinter.printMap(map);
        game.startAction(player,map);
        MapPrinter.printMap(map);
        game.startAction(jinBei,map);
        MapPrinter.printMap(map);
        game.startAction(player,map);
        MapPrinter.printMap(map);
        game.startAction(jinBei,map);
        MapPrinter.printMap(map);
        game.startAction(player,map);
        MapPrinter.printMap(map);
        game.startAction(jinBei,map);
        MapPrinter.printMap(map);
        game.startAction(player,map);
        MapPrinter.printMap(map);
        game.startAction(jinBei,map);
        MapPrinter.printMap(map);
        /*Console console = System.console();
          if(console==null)
        {
            System.out.println("不能使用控制台");
            return;
        }
        while(true){
            String str=System.console().readLine();
            System.out.println(str);
        }
        */
    }
}
