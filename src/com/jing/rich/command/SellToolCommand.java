package com.jing.rich.command;

import com.jing.rich.Map;
import com.jing.rich.Player;

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
    public void execute(Map map, Player player) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
