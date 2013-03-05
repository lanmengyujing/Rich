package com.jing.rich.action;

import com.jing.rich.IO;
import com.jing.rich.Phrases;
import com.jing.rich.Player;
import com.jing.rich.ground.Ground;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-1
 * Time: 下午3:51
 * To change this template use File | Settings | File Templates.
 */
public class MagicHouseAction extends AbstractReachPlaceAction {
    public MagicHouseAction(Player player, Ground ground) {
        super(player, ground);
    }

    @Override
    public void action() {
        IO.writeTo(Phrases.MAGIC_HOUSE_TIP);
    }
}
