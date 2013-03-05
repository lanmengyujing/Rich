package com.jing.rich.action;

import com.jing.rich.IO;
import com.jing.rich.Phrases;
import com.jing.rich.Player;
import com.jing.rich.command.CommandParser;
import com.jing.rich.exception.CommandNotFoundException;
import com.jing.rich.ground.Ground;
import com.jing.rich.tools.Prop;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-1
 * Time: 下午3:51
 * To change this template use File | Settings | File Templates.
 */
public class ToolHouseAction extends AbstractReachPlaceAction {
    public ToolHouseAction(Player player, Ground ground) {
        super(player, ground);
    }

    @Override
    public void action() {
        IO.writeTo(Phrases.TOOLHOUSE_WELCOME);
        IO.writeTo(Phrases.TOOLHOUSE_TIPS);
        IO.writeTo(Phrases.TOOLHOUSE_EXIT_TIPS);
        while (true) {
            if (player.getPoints() < Phrases.MIN_POINTS) {
                IO.writeTo(Phrases.POINTS_NOT_ENOUGH);
                return;
            }
            if (player.getProp().size() == Phrases.MAX_PROP_COUNT) {
                IO.writeTo(Phrases.HAVE_MAX_PROP);
                return;
            }
            IO.writeTo(Phrases.TOOLHOUSE_SELECT_TIPS);
            String commandStr = IO.readLine();
            if (commandStr.equals(Phrases.EXIT)) {
                IO.writeTo(Phrases.AFTER_EXIT);
                return;
            }
            try {
                CommandParser parser = new CommandParser();
                int num = parser.parsePropCommand(commandStr);
                parseProp(num);
            } catch (NumberFormatException e) {
                IO.writeTo(Phrases.WRONG_COMMAND);
            } catch (CommandNotFoundException e) {
                IO.writeTo(Phrases.WRONG_COMMAND);
            }
        }
    }

    private void parseProp(int num) {
        Prop prop = null;
        switch (num) {
            case 1:
                prop = Prop.ROAD_BLOCK;
                break;
            case 2:
                prop = Prop.ROBOT;
                break;
            case 3:
                prop = Prop.BOMB;
                break;
            default:
                throw new AssertionError();
        }
        if (player.getPoints() < prop.getPoints()) {
            IO.writeTo(Phrases.NOT_ENOUGH_TIP1 + prop.getPoints() +
                    Phrases.NOT_ENOUGH_TIP2 + prop.getName() + Phrases.PROP);
            return;
        }
        player.addProp(prop);
        IO.writeTo(Phrases.SELECTED_PROP + prop.getName());
    }
}
