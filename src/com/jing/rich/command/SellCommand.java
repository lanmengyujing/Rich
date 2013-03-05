package com.jing.rich.command;

import com.jing.rich.IO;
import com.jing.rich.Map;
import com.jing.rich.Phrases;
import com.jing.rich.Player;
import com.jing.rich.ground.Land;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-1
 * Time: 下午4:35
 * To change this template use File | Settings | File Templates.
 */
public class SellCommand implements Command {
    private int number;

    public SellCommand(int number) {
        this.number = number;
    }

    @Override
    public void execute(Map map, Player player) {
        Land land = (Land)map.getGround(number);
        sellLand(player,land);

    }

    private void sellLand(Player player,Land land) {
        Player owner = land.getOwner();
        if(owner == null){
            IO.writeTo(Phrases.WRONG_SELL);
        }else if(owner.getName().equals(player.getName())){
            player.sellLand(land);
            IO.writeTo(number + Phrases.SOLD_TIP );
        }else{
            IO.writeTo(Phrases.WRONG_SELL);
        }
    }
}
