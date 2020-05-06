package Processes;

import java.nio.charset.Charset;
import java.util.Random;

public class StringUtils {
    public static String getRandomString() {
        int GENERATED_STRING_LENGTH = 10;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder stringBuilder = new StringBuilder(GENERATED_STRING_LENGTH);

        for (int i = 0; i < GENERATED_STRING_LENGTH; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            stringBuilder.append(AlphaNumericString.charAt(index));
        }

        return stringBuilder.toString();
    }
}
