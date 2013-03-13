package com.jing.rich.tools;

import java.io.*;

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
            str.toLowerCase();
        } catch (IOException e) {
            e.printStackTrace();
            closeIn();
        }
        return str;
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
            newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void newLine() {
        System.out.print(System.getProperty("line.separator"));
    }

}
