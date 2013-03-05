package com.jing.rich.exception;

import com.jing.rich.tools.Phrases;


public class NumberOfLandNotFoundException extends GameException {
    @Override
    public String getMessage() {
        return Phrases.BEYOND_GROUND_COUNT;
    }
}
