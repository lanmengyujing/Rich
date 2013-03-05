package com.jing.rich;

import java.io.Console;


public class RichGameStart {
    public static void main(String[] args) {
        Console console = System.console();
        /* if(console==null)
       {
           System.writer.println("不能使用控制台");
           return;
       }
       while(true){
           String str=System.console().readLine();
           System.writer.println(str);
       } */
        Game game = new Game();
        game.init();
        game.run();
    }
}
