package com.jing.rich.action;

import com.jing.rich.tools.IO;
import com.jing.rich.tools.Phrases;
import com.jing.rich.Player;
import com.jing.rich.CommandParser;
import com.jing.rich.exception.CommandNotFoundException;
import com.jing.rich.ground.Ground;
import com.jing.rich.tools.Prop;


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
        player.buyProp(prop);
        IO.writeTo(Phrases.SELECTED_PROP + prop.getName());
    }
}
