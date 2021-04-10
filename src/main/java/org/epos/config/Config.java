package org.epos.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class Config {

    private static final Map<String, String> env = new HashMap<String, String>();

    static {
        Config.loadEnv();
    }

    private static void loadEnv() {
        try {
            File myObj = new File(".env");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split("=");
                if (!data[0].isEmpty() && data[0].charAt(0) != '#') {
                    env.put(data[0], data[1]);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return env.get(key);
    }
}
