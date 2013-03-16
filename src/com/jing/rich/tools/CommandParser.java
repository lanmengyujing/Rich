package com.jing.rich.tools;

import com.jing.rich.Game;
import com.jing.rich.Player;
import com.jing.rich.Role;
import com.jing.rich.command.*;
import com.jing.rich.exception.CommandNotFoundException;
import com.jing.rich.exception.WrongNumberForPlayerException;

import java.util.ArrayList;
import java.util.List;

public class CommandParser {

    public Command ParseCommand(String commandString) throws CommandNotFoundException {
        Command command;
        commandString = commandString.trim();
        String[] commands = commandString.split(" ");
        if (commands.length == 1) {
            command = createShortCommand(commands[0].toLowerCase());
        } else if (commands.length == 2) {
            command = createLongCommand(commands);
        } else {
            throw new CommandNotFoundException();
        }
        if (command == null) {
            throw new CommandNotFoundException();
        }
        return command;
    }

    private Command createShortCommand(String commandStr) {
        Command command;
        if (commandStr.equals(Phrases.COMMAND_LIST[0])) {
            command = new RollCommand();
        } else if (commandStr.equals(Phrases.COMMAND_LIST[3])) {
            command = new RobotCommand();
        } else if (commandStr.equals(Phrases.COMMAND_LIST[6])) {
            command = new QueryCommand();
        } else if (commandStr.equals(Phrases.COMMAND_LIST[7])) {
            command = new HelpCommand();
        } else if (commandStr.equals(Phrases.COMMAND_LIST[8])) {
            command = new QuitCommand();
        } else {
            command = null;
        }
        return command;
    }

    private Command createLongCommand(String[] commands) throws CommandNotFoundException {
        Command command;
        String commandStr = commands[0].toLowerCase();
        int number = parseSecondInput(commands);
        if (commandStr.equals(Phrases.COMMAND_LIST[1])) {
            command = new BlockCommand(number);
        } else if (commandStr.equals(Phrases.COMMAND_LIST[2])) {
            command = new BombCommand(number);
        } else if (commandStr.equals(Phrases.COMMAND_LIST[4])) {
            command = new SellCommand(number);
        } else if (commandStr.equals(Phrases.COMMAND_LIST[5])) {
            command = new SellToolCommand(number);
        } else {
            command = null;
        }
        return command;
    }

    private int parseSecondInput(String[] command) throws CommandNotFoundException {
        int code;
        try {
            code = Integer.parseInt(command[1]);
        } catch (NumberFormatException e) {
            throw new CommandNotFoundException();
        }
        return code;
    }

    public List<Player> parsePlayersInitCommand(String command) throws WrongNumberForPlayerException {
        List<Player> players = new ArrayList<Player>();
        for (int i = 0; i < command.length(); i++) {
            char number = command.charAt(i);
            int playerNum = Integer.parseInt(String.valueOf(number));
            Role playerRole = Role.getRoleByNumber(playerNum);
            Player player = new Player(0, Game.INIT_CASH, playerRole, new Assets());
            players.add(player);
        }
        return players;
    }

    public int parseGiftCommand(String command) throws CommandNotFoundException {
        int num = Integer.valueOf(command);
        if (1 <= num && num <= 3) {
            return num;
        } else {
            throw new CommandNotFoundException();
        }
    }

    public int parsePropCommand(String commandStr) throws CommandNotFoundException {
        return parseGiftCommand(commandStr);
    }
}


