package com.jing.rich.command;

import com.jing.rich.tools.IO;
import com.jing.rich.Map;
import com.jing.rich.tools.Phrases;
import com.jing.rich.Player;

public class HelpCommand implements Command {


    @Override
    public void execute(Map map, Player player) {
        IO.writeTo(Phrases.HELP_MENU);
    }
}
