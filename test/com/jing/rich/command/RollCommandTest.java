package com.jing.rich.command;

import com.jing.rich.Assets;
import com.jing.rich.Map;
import com.jing.rich.Player;
import com.jing.rich.Role;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-3
 * Time: 下午3:47
 * To change this template use File | Settings | File Templates.
 */
public class RollCommandTest {
    RollCommand rollCommand;
    Map map;
    Player player;
    @Before
    public void setUp() throws Exception {
        rollCommand = new RollCommand();
        map = Map.getInstance();
        player = new Player(0, 2000, Role.jinBeiBei, new Assets());
    }



    @Test
    public void testExecute() throws Exception {
        rollCommand.execute(map, player);
        assertThat( player.getPosition(),not(0));
    }
}
