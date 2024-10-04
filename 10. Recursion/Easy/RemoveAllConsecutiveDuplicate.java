package Recursion.Easy;

class RemoveAllConsecutiveDuplicate {
    public static String deleteConsecutiveString(String str) {
        if(str.length() <= 1) return str;
        if(str.charAt(0) == str.charAt(1)) {
            return deleteConsecutiveString(str.substring(1));
        } else {
            return str.charAt(0) + deleteConsecutiveString(str.substring(1));
        }
    }
    public static void main(String[] args) {
        String s = "aaaaabbbbbb";
        System.out.println(s);
        System.out.println(deleteConsecutiveString(s));
    }
}
