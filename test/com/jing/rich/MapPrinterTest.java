package com.jing.rich;


import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-2-28
 * Time: 下午5:36
 * To change this template use File | Settings | File Templates.
 */
public class MapPrinterTest{

    @Test
    public void printMapTest(){
        MapPrinter.printMap(Map.getInstance());
    }
}
