package com.jing.rich.command;

import com.jing.rich.IO;
import com.jing.rich.Map;
import com.jing.rich.Phrases;
import com.jing.rich.Player;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-1
 * Time: 下午4:34
 * To change this template use File | Settings | File Templates.
 */
public class HelpCommand implements Command {


    @Override
    public void execute(Map map, Player player) {
        IO.writeTo(Phrases.HELP_MENU);
    }
}
