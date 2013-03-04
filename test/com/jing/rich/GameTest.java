package com.jing.rich;

import com.jing.rich.ground.Land;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntellliJ IDEA.
 * User: Administrator
 * Date: 14-2-6
 * Time: 下午4:58
 * To change this template use File | Settings | File Templates.
 */
public class GameTest {
    private Game game;
    Map map;
    @Before
    public void setup(){
        game = new  Game();
        map = Map.getInstance();
    }


}
