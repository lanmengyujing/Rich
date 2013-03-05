package com.jing.rich.ground;

import com.jing.rich.Player;
import com.jing.rich.exception.PropPositonException;
import com.jing.rich.tools.Prop;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-2-24
 * Time: 下午12:14
 * To change this template use File | Settings | File Templates.
 */
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

    boolean hasProp();
}
