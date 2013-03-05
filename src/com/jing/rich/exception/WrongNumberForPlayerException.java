package com.jing.rich.exception;

import com.jing.rich.Phrases;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-3
 * Time: 下午12:01
 * To change this template use File | Settings | File Templates.
 */
public class WrongNumberForPlayerException extends GameException{
    @Override
    public String getMessage() {
        return Phrases.WRONG_INIT_FOR_PLAYER;
    }
}
