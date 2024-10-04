package Strings;

class StrStr {

    public static int strStr(String haystack, String needle){
        int result = -1;
        StringBuilder s1 = new StringBuilder(haystack);
        
        result = s1.indexOf(needle);

        return result;
    }

    public static void main(String[] args) {
        String hs = "leetcode";
        String nd = "leeto";
        System.out.println(strStr(hs, nd));
    }

}