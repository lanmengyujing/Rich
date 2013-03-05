package com.jing.rich.command;

import com.jing.rich.Map;
import com.jing.rich.Player;
import com.jing.rich.exception.GameException;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-1
 * Time: 下午4:30
 * To change this template use File | Settings | File Templates.
 */
public interface Command {
    public void execute(Map map, Player player) throws GameException;
}
