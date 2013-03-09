package com.jing.rich.command;

import com.jing.rich.Player;
import com.jing.rich.RichMap;
import com.jing.rich.Role;
import com.jing.rich.ground.Land;
import com.jing.rich.tools.Assets;
import com.jing.rich.tools.Prop;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class QueryCommandTest {
    Player player;
    RichMap richMap;
    QueryCommand command;
    @Before
    public void setUp() throws Exception {
        player = new Player(0, 1000, Role.A_TU_BO, new Assets());
        player.addPoints(1000);
        richMap = RichMap.getInstance();
        player.buyLand(richMap.getGround(8));
        player.buyLand(richMap.getGround(32));
        player.upDateLand((Land)richMap.getGround(32));
        player.buyProp(Prop.BOMB);
        player.buyProp(Prop.ROBOT);
        player.buyProp(Prop.ROAD_BLOCK);
        player.buyProp(Prop.ROAD_BLOCK);
        command = new QueryCommand();
    }

    @Test
    public void testQueryForProp() throws Exception {
        command.execute(richMap, player);
        Map<Prop, Integer> props = new HashMap<Prop, Integer>();
        props.put(Prop.ROBOT, 1);
        props.put(Prop.BOMB, 1);
        props.put(Prop.ROAD_BLOCK, 2);
        assertThat(player.getProp(), is(props));
    }

    @Test
    public void testQueryForPropWhenUseRobot() throws Exception {
        command.execute(richMap, player);
        player.useRobot(richMap);
        Map<Prop, Integer> props = new HashMap<Prop, Integer>();
        props.put(Prop.BOMB, 1);
        props.put(Prop.ROAD_BLOCK, 2);
        assertThat(player.getProp(), is(props));
    }
}
