package com.jing.rich.exception;

import com.jing.rich.tools.Phrases;

public class PropPositonException extends GameException {
    @Override
    public String getMessage() {
        return Phrases.LAND_HAS_PROP;
    }
}
