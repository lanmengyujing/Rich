package com.jing.rich.exception;


import com.jing.rich.tools.Phrases;

public class PositionHasPlayerException extends GameException {
    @Override
    public String getMessage() {
        return Phrases.POSITION_HAS_PLAYER;
    }
}
