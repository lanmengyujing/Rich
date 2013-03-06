package com.jing.rich.command;

import com.jing.rich.Map;
import com.jing.rich.Player;
import com.jing.rich.exception.GameException;
import com.jing.rich.tools.IO;
import com.jing.rich.tools.Phrases;
import com.jing.rich.tools.Prop;

public class SellToolCommand implements Command {
    private int number;

    public SellToolCommand(int number) {
        this.number = number;
    }

    @Override
    public void execute(Map map, Player player) throws GameException {
        Prop prop = Prop.getPropByCode(number);
        player.sellProp(prop);
        IO.writeTo(Phrases.SELLTOOL + prop.getName());
    }
}
