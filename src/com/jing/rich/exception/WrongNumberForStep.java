package com.jing.rich.exception;

import com.jing.rich.Phrases;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-5
 * Time: 下午6:12
 * To change this template use File | Settings | File Templates.
 */
public class WrongNumberForStep extends GameException {
    @Override
    public String getMessage() {
        return Phrases.WRONG_NUMBER;
    }
}
