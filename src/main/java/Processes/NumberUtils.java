package Processes;

import static java.lang.String.*;

public class NumberUtils {
    public static String getRandomNumberAsString() {
        return valueOf(getRandomNumber());
    }

    private static int getRandomNumber() {
        return (int)(Math.random()*1000000);
    }
}
