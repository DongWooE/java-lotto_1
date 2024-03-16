package util;

import java.util.regex.Pattern;

public class CheckUtil {

    private static final Pattern pattern = Pattern.compile("\\d");

    public static boolean isNumber(String s) {
        return pattern.matcher(s).find();
    }
}
