package com.jing.rich.exception;

import com.jing.rich.IO;
import com.jing.rich.Phrases;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-5
 * Time: 下午3:57
 * To change this template use File | Settings | File Templates.
 */
public class NumberOfLandNotFoundException extends GameException {
    @Override
    public String getMessage(){
        return Phrases.BEYOND_GROUND_COUNT;
    }
}
