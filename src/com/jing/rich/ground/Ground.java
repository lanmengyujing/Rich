package com.jing.rich.ground;

import com.jing.rich.state.GroundState;
import com.jing.rich.Player;
import com.jing.rich.RichMap;
import com.jing.rich.action.ReachPlaceAction;
import com.jing.rich.tools.Prop;

public interface Ground {
    public int getNumber();

    public void setNumber(int number);

    public Prop getProp();

    public void addProp(Prop prop);

    public void removeProp();

    public void addPlayer(Player player);

    public void removePlayer(Player player);

    public Player getCurPlayer();

    public String getSign();

    public boolean hasProp();

    public boolean hasPlayer();

    ReachPlaceAction getActionType(Player player, Ground ground, RichMap richMap);

    GroundState getState();
}
