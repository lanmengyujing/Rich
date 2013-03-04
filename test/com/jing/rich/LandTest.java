package com.jing.rich;

import com.jing.rich.exception.UpdateException;
import com.jing.rich.ground.Land;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-2-28
 * Time: 下午9:40
 * To change this template use File | Settings | File Templates.
 */
public class LandTest {
    Land land;
    @Before
    public void setup(){
        land = new Land(200);
    }

    @Test(expected = UpdateException.class)
    public void updateExceptionTest() throws UpdateException {
        for(int  i = 0; i <= 4 ; i++){
            land.upDate();
        }
    }
}
