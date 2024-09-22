
public class ValidNumber {

    public static boolean isNumber(String s) {
        if (s == null || s.trim().isEmpty()) return false;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("Infinity"));
        System.out.println(isNumber("e"));
    }
}