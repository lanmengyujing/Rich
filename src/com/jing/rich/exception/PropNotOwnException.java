package com.jing.rich.exception;

import com.jing.rich.tools.Phrases;


public class PropNotOwnException extends GameException {
    @Override
    public String getMessage() {
        return Phrases.NOT_OWN_PROP;
    }
}
