package com.jing.rich;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-2-6
 * Time: 下午4:40
 * To change this template use File | Settings | File Templates.
 */
public class Dice {
    private static final int MAX = 6;
    private static final int MIN = 1;

    public static int roll() {
        Random rand = new Random();
        int number = rand.nextInt(MAX) % (MAX - MIN + 1) + MIN;
        return number;
    }

}
