package com.jing.rich.exception;

import com.jing.rich.Phrases;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-2-28
 * Time: 下午9:31
 * To change this template use File | Settings | File Templates.
 */
public class UpdateException extends GameException {

    public String getMessage() {
        return Phrases.UPDATE_TOO_MUCH;
    }
}
