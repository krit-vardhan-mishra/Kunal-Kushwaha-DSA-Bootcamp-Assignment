package Strings;

class SplitTwoString {

    public static boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }
    
    private static boolean check(String a, String b) {
        int i = 0, j = b.length() - 1;
        while (i < j && a.charAt(i) == b.charAt(j)) {
            i++;
            j--;
        }
        return isPalindrome(a, i, j) || isPalindrome(b, i, j);
    }
    
    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    

    public static void main(String[] args) {
        System.out.println(checkPalindromeFormation("x", "y"));
        System.out.println(checkPalindromeFormation("xbdef", "xecab"));
        System.out.println(checkPalindromeFormation("ulacfd", "jizalu"));
    }    
}
