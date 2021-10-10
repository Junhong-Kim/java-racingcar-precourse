package racinggame.utils;

public class StringUtils {

    private StringUtils() {
    }

    public static boolean isNumber(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
