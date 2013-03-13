package com.jing.rich.action.reachLandAction;

import com.jing.rich.Player;
import com.jing.rich.ground.Land;
import com.jing.rich.tools.IO;
import com.jing.rich.tools.Phrases;

public abstract class LandActionBehavior {
    public void action(Land land, Player player) {
        showTips(land, player);
        if (isInPayTollState()) {
            dealWithLand(land, player);
            return;
        }
        if (customerWantAct()) {
            dealWithLand(land, player);
        }
    }

    abstract void showTips(Land land, Player player);

    abstract void dealWithLand(Land land, Player player);

    boolean isInPayTollState() {
        return false;
    }

    final boolean customerWantAct() {
        while (true) {
            String command = IO.readLine();
            if (command.equals(Phrases.YES)) {
                return true;
            } else if (command.equals(Phrases.NO)) {
                return false;
            } else {
                IO.writeTo(Phrases.WRONG_COMMAND);
            }
        }
    }
}

