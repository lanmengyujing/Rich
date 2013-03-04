package com.jing.rich;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-3-1
 * Time: 上午11:04
 * To change this template use File | Settings | File Templates.
 */
public class IO {
    private static BufferedReader reader;
    private static BufferedWriter writer;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static String readLine() {
        String str = null;
        try {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            closeIn();
        }
        return str.toLowerCase();
    }

    private static void closeIn() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeTo(String str) {
        try {
            writer.write(str);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void newLine() {
        System.out.print(System.getProperty("line.separator"));
    }

}
