package com.jing.rich;

import com.jing.rich.command.*;
import com.jing.rich.exception.CommandNotFoundException;
import com.jing.rich.exception.InitCashException;
import com.jing.rich.exception.WrongNumberForPlayerException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-2-6
 * Time: 下午4:43
 * To change this template use File | Settings | File Templates.
 */
public class Game {
    private List<Player> players = new ArrayList<Player>();
    private Map map;
    public static int INIT_CASH = 1000;

    public Game() {
    }

    public int getPlayerAmount() {
        return players.size();
    }

    public List<Player> getPlayerList() {
        return players;
    }

    public void init() {
        initMap();
        initCash();
        initPlayers();
    }

    private void initMap() {
        map = Map.getInstance();
        MapPrinter.printMap(map);
    }

    private void initCash() {
        IO.writeTo(Phrases.CASH_SET_TIPS);
        IO.newLine();
        while (true) {
            String cashStr = IO.readLine();
            try {
                setInitCash(cashStr);
                return;
            } catch (InitCashException e) {
                IO.writeTo(e.getMessage());
            }
        }
    }

    private void setInitCash(String cashStr) throws InitCashException {
        if (cashStr.equals("e")) {
            Game.INIT_CASH = 10000;
            return;
        }
        int cash = Integer.valueOf(cashStr);
        if (cash >= 1000 && cash <= 50000) {
            Game.INIT_CASH = cash;
        } else {
            throw new InitCashException();
        }
    }

    private void initPlayers() {
        IO.writeTo(Phrases.SELECT_PLAYER_TIP);
        IO.newLine();
        String playersStr = IO.readLine();
        CommandParser parser = new CommandParser();
        players = parser.parsePlayersInitCommand(playersStr);
    }

    public void run() {
        int index = -1;
        while (true) {
            Player player = players.get((index + 1) % players.size());
            startAction(player,map);
            MapPrinter.printMap(map);
            index++;
        }
    }
      ///xuyaogaiiiiiii
    public void startAction(Player player, Map map) {
        if(player.isBogged()){
            IO.writeTo(player.getRole().getName() + Phrases.LUN_KONG);
            return;
        }
        while (true) {
            Command command = getCommand(player);
            command.execute(map, player);
            if (command instanceof RollCommand) {
                IO.writeTo(player.getRole().getName()+ Phrases.HUIHE_JIESU);
                IO.writeTo(System.getProperty("line.separator"));
                break;
            }
        }
    }

    public Command getCommand(Player player) {
        while (true) {
            IO.writeTo(player.getRole().getName() + Phrases.COMMAND_PREFIX);
            String commandStr = IO.readLine();
            CommandParser parser = new CommandParser();
            try {
                Command command = parser.ParseCommand(commandStr);
                return command;
            } catch (CommandNotFoundException e) {
                IO.writeTo(e.getMessage());
                IO.writeTo(System.getProperty("line.separator"));
            }
        }
    }
}
