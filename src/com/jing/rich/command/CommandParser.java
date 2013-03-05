package com.jing.rich.command;

import com.jing.rich.*;
import com.jing.rich.exception.CommandNotFoundException;
import com.jing.rich.exception.WrongNumberForPlayerException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-2-11
 * Time: 下午4:16
 * To change this template use File | Settings | File Templates.
 */
public class CommandParser {

    public Command ParseCommand(String commandString) throws CommandNotFoundException {
        Command command = null;
        String[] commands = commandString.split(" ");
        if (commands.length > 2 || commands.length < 1){
            IO.writeTo(Phrases.WRONG_COMMAND);
            command =  null;
        }

        String commandStr = commands[0].toLowerCase();
        int number = parseSecondInput(commands);

        if(commandStr.equals(Phrases.COMMAND_LIST[0])){
            command = new RollCommand();
        }else if(commandStr.equals(Phrases.COMMAND_LIST[1])){
            command = new BlockCommand(number);
        }else if(commandStr.equals( Phrases.COMMAND_LIST[2])){
            command = new BombCommand(number);
        }else if(commandStr.equals(Phrases.COMMAND_LIST[3])){
            command = new RobotCommand();
        }else if(commandStr.equals( Phrases.COMMAND_LIST[4])){
            command = new SellCommand(number);
        }else if(commandStr.equals(Phrases.COMMAND_LIST[5])){
            command = new SellToolCommand(number);
        }else if(commandStr.equals(Phrases.COMMAND_LIST[6])){
            command = new QueryCommand();
        }else if(commandStr.equals(Phrases.COMMAND_LIST[7])){
            command = new HelpCommand();
        }else if(commandStr.equals(Phrases.COMMAND_LIST[8])){
            command = new QuitCommand();
        }
        if(null==command){
            throw new CommandNotFoundException();
        }
        return command;
    }

    private int parseSecondInput(String[] command){
        int code = 0;
        try {
            if (command.length == 2)
                code = Integer.parseInt(command[1]);
        } catch (NumberFormatException e) {
            return 0;
        }
        return code;
    }

    public List<Player> parsePlayersInitCommand(String command) {
        List<Player> players = new ArrayList<Player>();
        for (int i = 0; i < command.length(); i++) {
            char number = command.charAt(i);
            try{
                int playerNum = Integer.parseInt(String.valueOf(number));
                Role playerRole = parsePlayerRole(playerNum);
                Player player = new Player(0, Game.INIT_CASH, playerRole, new Assets());
                players.add(player);
            }catch (NumberFormatException e){
                e.getMessage();
            }catch (WrongNumberForPlayerException e){
                e.getMessage();
            }
        }
        return players;
    }

    private Role parsePlayerRole(int playerNum) throws WrongNumberForPlayerException {
        Role playerRole;
        switch (playerNum) {
            case 1:
                playerRole = Role.qianFuRen;
                break;
            case 2:
                playerRole = Role.aTuBo;
                break;
            case 3:
                playerRole = Role.sunXiaoMei;
                break;
            case 4:
                playerRole = Role.jinBeiBei;
                break;
            default:
                throw new WrongNumberForPlayerException();
        }
        return playerRole;
    }

    public int parseGiftCommand(String command) throws CommandNotFoundException {
            int num = Integer.valueOf(command);
        if( 1 <= num && num<=3 ){
            return num;
        } else {
            throw new CommandNotFoundException();
        }
    }

    public int parsePropCommand(String commandStr) throws CommandNotFoundException {
        return parseGiftCommand(commandStr);
    }
}


