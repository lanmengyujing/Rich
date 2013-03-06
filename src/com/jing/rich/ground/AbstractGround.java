package com.jing.rich.ground;

import com.jing.rich.Player;
import com.jing.rich.tools.Prop;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractGround implements Ground {
    protected int number;
    protected Prop prop;
    protected List<Player> playerList = new ArrayList<Player>();

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Prop getProp() {
        return prop;
    }


    public void addProp(Prop prop) {
        if (this.prop == null) {
            this.prop = prop;
        }
    }

    public void removeProp() {
        prop = null;
    }

    public boolean hasProp() {
        if (prop != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean hasPlayer() {
        if (playerList.isEmpty()) {
            return false;
        }
        return true;
    }

    public void addPlayer(Player player) {
        playerList.add(player);
    }

    public void removePlayer(Player player) {
        playerList.remove(player);
    }

    public Player getCurPlayer() {
        Player player = null;
        if (playerList.size() > 0) {
            player = playerList.get(playerList.size() - 1);
        }
        return player;
    }

    abstract public String getSign();


    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof AbstractGround) {
            AbstractGround ground = (AbstractGround) object;
            if (this.number == ground.number) {
                return true;
            }
            return false;
        }
        return false;
    }

}
