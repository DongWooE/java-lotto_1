package domain;

import java.util.regex.Pattern;

public class Calculate {

    private static Pattern pattern = Pattern.compile("\\d");

    public static int plus(int firstInput, int secondInput) {
        return firstInput + secondInput;
    }

    private static boolean isNumber(String s) {
        return pattern.matcher(s).find();
    }

    public static int minus(int firstInput, int secondInput) {
        return firstInput - secondInput;
    }

    public static int multiple(int firstInput, int secondInput) {
        return firstInput * secondInput;
    }

    public static int divide(int firstInput, int secondInput) {
        return firstInput / secondInput;
    }
}
