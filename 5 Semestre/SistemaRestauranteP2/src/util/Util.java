package util;

public class Util {
    public static String validNumber(String t){
        return t==null || t.isEmpty() || !t.matches("[0-9.]+") ? "0" : t;
    }
}
