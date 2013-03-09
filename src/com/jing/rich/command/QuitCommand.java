package com.jing.rich.command;

import com.jing.rich.RichMap;
import com.jing.rich.tools.IO;
import com.jing.rich.tools.Phrases;
import com.jing.rich.Player;

public class QuitCommand implements Command {


    @Override
    public void execute(RichMap richMap, Player player) {
        IO.writeTo(Phrases.FOECE_EXIT);
        System.exit(0);
    }
}
