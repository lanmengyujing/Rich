package com.jing.rich.action;

import com.jing.rich.RichMap;
import com.jing.rich.action.reachLandAction.BuyLand;
import com.jing.rich.action.reachLandAction.LandActionBehavior;
import com.jing.rich.action.reachLandAction.PayToll;
import com.jing.rich.action.reachLandAction.UpdateLand;
import com.jing.rich.Player;
import com.jing.rich.ground.Ground;
import com.jing.rich.ground.Land;


public class LandAction extends AbstractReachPlaceAction {
    private RichMap richMap;
    private LandActionBehavior actionBehavior;

    public LandAction(Player player, Ground ground, RichMap richMap) {
        super(player, ground);
        this.richMap = richMap;
    }

    @Override
    public void  action() {
        Land land = (Land) ground;
        Player owner = land.getOwner();
        setActionType(owner);
        actionBehavior.action(land, player);
    }

    private void setActionType(Player owner){
        if (null == owner) {
            actionBehavior = new BuyLand();
        } else if (owner.getName().equals(player.getName())) {
            actionBehavior = new UpdateLand();
        } else {
            Ground ownerPlace = richMap.getGround(owner.getPosition());
            actionBehavior = new PayToll(owner, ownerPlace);
        }
    }
}