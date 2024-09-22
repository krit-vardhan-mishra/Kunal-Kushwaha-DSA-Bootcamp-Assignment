public class FirstUpperCase {

    public static char firstUpperCase(String s) {
        if(s.isEmpty()) return 0;

        if(Character.isUpperCase(s.charAt(0))) return s.charAt(0);

        return firstUpperCase(s.substring(1));
    }

    public static void main(String[] args) {
        String s = "geekS";
        System.out.println(firstUpperCase(s));
    }
}
