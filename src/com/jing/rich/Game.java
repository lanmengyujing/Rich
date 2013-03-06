package com.jing.rich;

import com.jing.rich.command.*;
import com.jing.rich.exception.CommandNotFoundException;
import com.jing.rich.exception.GameException;
import com.jing.rich.exception.InitCashException;
import com.jing.rich.exception.WrongNumberForPlayerException;
import com.jing.rich.tools.CommandParser;
import com.jing.rich.tools.IO;
import com.jing.rich.tools.Phrases;
import enigma.console.Console;
import enigma.console.TextAttributes;
import enigma.core.Enigma;

import java.awt.*;
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
    public static final Console console = Enigma.getConsole("Rich Game");
    public static Color defaultForeground = Color.white;
    public static Color defaultBackground = Color.black;
    static {
        TextAttributes defautAttrs = new TextAttributes(defaultForeground, defaultBackground);
        console.setTextAttributes(defautAttrs);
    }

    private List<Player> players = new ArrayList<Player>();
    private Map map;
    public static int INIT_CASH = 10000;

    public void setPlayers(List<Player> players) {
        this.players = players;
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
        while (true) {
            String cashStr = IO.readLine();
            try {
                setInitCash(cashStr);
                return;
            } catch (NumberFormatException e) {
                IO.writeTo(Phrases.WRONG_COMMAND);
            } catch (InitCashException e) {
                IO.writeTo(e.getMessage());
            }
        }
    }

    private void setInitCash(String cashStr) throws InitCashException {
        if (cashStr.equals("y")) {
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
        while (true) {
            String playersStr = IO.readLine();
            CommandParser parser = new CommandParser();
            try {
                players = parser.parsePlayersInitCommand(playersStr);
                setPlayers(players);
                break;
            } catch (NumberFormatException e) {
                IO.writeTo(Phrases.WRONG_COMMAND);
            } catch (WrongNumberForPlayerException e) {
                IO.writeTo(e.getMessage());
            }
        }
    }

    public void run() {
        int index = -1;
        while (!judgeGameOver()) {
            Player player = players.get((index + 1) % players.size());
            startAction(player, map);
            MapPrinter.printMap(map);
            if (judgeRemovePlayer(player)) {
                index--;
            }
            index++;
        }
        Player player = getWinner();
        if (null != player) {
            IO.writeTo(player.getName() + Phrases.GAMEOVER);
        }
    }

    public void startAction(Player player, Map map) {
        player.reduceFreePass();
        if (player.isBogged()) {
            IO.writeTo(player.getRole().getName() + Phrases.LUN_KONG);
            return;
        }
        while (true) {
            try {
                Command command = getCommand(player);
                command.execute(map, player);
                if (command instanceof RollCommand) {
                    IO.writeTo(player.getRole().getName() + Phrases.HUIHE_JIESU);
                    break;
                }
            } catch (GameException e) {
                IO.writeTo(e.getMessage());
                continue;
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
            }
        }
    }

    public boolean judgeRemovePlayer(Player player) {
        if (player.isBankrupt()) {
            IO.writeTo(player.getName() + Phrases.BANKRUPT);
            players.remove(player);
            return true;
        }
        return false;
    }

    public boolean judgeGameOver() {
        if (getPlayerAmount() == 1) {
            return true;
        }
        return false;
    }

    public int getPlayerAmount() {
        return players.size();
    }

    public Player getWinner() {
        if (judgeGameOver()) {
            return players.get(0);
        } else {
            return null;
        }
    }
}
