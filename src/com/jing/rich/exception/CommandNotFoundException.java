package com.jing.rich.exception;

import com.jing.rich.Phrases;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-1
 * Time: 下午4:39
 * To change this template use File | Settings | File Templates.
 */
public class CommandNotFoundException extends GameException {
    public String getMessage() {
        return Phrases.WRONG_COMMAND;
    }
}
