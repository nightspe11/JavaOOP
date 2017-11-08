package kursach3.io;

public class ParseInt {
    public static int parseInt(String s) {
        if (isInt(s)) return Integer.parseInt(s);
        else return 0;
    }

    private static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
