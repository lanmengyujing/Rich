package com.jing.rich.exception;

import com.jing.rich.Phrases;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-1
 * Time: 下午2:50
 * To change this template use File | Settings | File Templates.
 */
public class InitCashException extends GameException {

    public String getMessage() {
        return Phrases.WRONG_INIT_CASH;
    }
}
