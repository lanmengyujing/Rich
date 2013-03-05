package com.jing.rich.action;

import com.jing.rich.tools.IO;
import com.jing.rich.tools.Phrases;
import com.jing.rich.Player;
import com.jing.rich.ground.Ground;


public class PrisonAction extends AbstractReachPlaceAction {
    public PrisonAction(Player player, Ground ground) {
        super(player, ground);
    }

    @Override
    public void action() {
        IO.writeTo(Phrases.IN_PRISON_TIP);
        player.goPrison();
    }
}
