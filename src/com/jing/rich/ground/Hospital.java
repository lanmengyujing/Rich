package com.jing.rich.ground;


import com.jing.rich.Player;
import com.jing.rich.RichMap;
import com.jing.rich.action.HospitalAction;
import com.jing.rich.action.ReachPlaceAction;

public class Hospital extends AbstractGround {
    @Override
    public String getSign() {
        return "H";
    }

    @Override
    public ReachPlaceAction getActionType(Player player, Ground ground, RichMap richMap) {
        return new HospitalAction(player, ground);
    }
}
