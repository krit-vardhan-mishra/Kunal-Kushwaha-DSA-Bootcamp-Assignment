package Strings;

class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        if(s.length() == 1) return true;

        s = s.replaceAll("\\s+", "");
        s = s.replaceAll("[^0-9a-zA-Z]", "");
        s = s.toLowerCase();
        
        int i = 0, j = s.length()-1;
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }
}
