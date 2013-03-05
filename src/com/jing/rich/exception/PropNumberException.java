package com.jing.rich.exception;

import com.jing.rich.tools.Phrases;


public class PropNumberException extends GameException {
    @Override
    public String getMessage() {
        return Phrases.NUMBER_FOR_PROP_WRONG;
    }
}
