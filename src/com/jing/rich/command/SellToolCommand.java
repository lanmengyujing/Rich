package com.jing.rich.command;

import com.jing.rich.IO;
import com.jing.rich.Map;
import com.jing.rich.Phrases;
import com.jing.rich.Player;
import com.jing.rich.exception.GameException;
import com.jing.rich.exception.PropNumberException;
import com.jing.rich.tools.Prop;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-1
 * Time: 下午4:35
 * To change this template use File | Settings | File Templates.
 */
public class SellToolCommand implements Command {
    private int number;

    public SellToolCommand(int number) {
        this.number = number;
    }

    @Override
    public void execute(Map map, Player player) throws GameException{
        Prop prop = Prop.getPropByCode(number);
        player.sellProp(prop);
    }
}
