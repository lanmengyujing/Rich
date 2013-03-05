package com.jing.rich;

import com.jing.rich.exception.UpdateException;
import com.jing.rich.ground.Land;
import com.jing.rich.tools.Prop;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


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

    @Test
    public void shouldHasPropWhenPutProp(){
        land.addProp(Prop.BOMB);
        assertThat(land.hasProp(),is(true));
    }


}
