package com.jing.rich.exception;

import com.jing.rich.tools.Phrases;


public class WrongNumberForPlayerException extends GameException {
    @Override
    public String getMessage() {
        return Phrases.WRONG_INIT_FOR_PLAYER;
    }
}
