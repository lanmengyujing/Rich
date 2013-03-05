package com.jing.rich.exception;

import com.jing.rich.tools.Phrases;


public class CommandNotFoundException extends GameException {
    @Override
    public String getMessage() {
        return Phrases.WRONG_COMMAND;
    }
}
