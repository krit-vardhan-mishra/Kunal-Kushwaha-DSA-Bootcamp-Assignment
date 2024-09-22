public class LengthOfString {
    public static int findLength(String str) {
        if(str.isEmpty()) return 0;

        return 1 + findLength(str.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(findLength("abcd"));
    }
}
