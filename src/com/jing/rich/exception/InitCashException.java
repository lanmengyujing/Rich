package com.jing.rich.exception;

import com.jing.rich.tools.Phrases;


public class InitCashException extends GameException {
    @Override
    public String getMessage() {
        return Phrases.WRONG_INIT_CASH;
    }
}
