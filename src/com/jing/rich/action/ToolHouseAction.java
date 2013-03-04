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
        IO.newLine();
        if(player.getPoints() < 30){
            return;
        }
        CommandParser parser = new CommandParser();
        String commandStr = IO.readLine();
        try {
            int num = parser.parsePropCommand(commandStr);
            parseProp(num);
        } catch (NumberFormatException e) {
            IO.writeTo(Phrases.WRONG_SELECTION);
        } catch (CommandNotFoundException e) {
            IO.writeTo(Phrases.WRONG_SELECTION);
        }

    }

    private void parseProp(int num) {
        Prop prop = null;
        switch (num) {
            case 1:
                prop = Prop.RoadBlock;
                break;
            case 2:
                prop = Prop.Robot;
                break;
            case 3:
                prop = Prop.Bomb;
                break;
            default:
                throw new AssertionError();
        }
        player.addProp(prop);
    }
}
