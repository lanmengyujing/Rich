package com.jing.rich.exception;

import com.jing.rich.tools.Phrases;


public class UpdateException extends GameException {
    @Override
    public String getMessage() {
        return Phrases.UPDATE_TOO_MUCH;
    }
}
