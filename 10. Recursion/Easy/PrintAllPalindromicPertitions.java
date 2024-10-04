package Recursion.Easy;

import java.util.ArrayList;

class PrintAllPalindromicPertitions {
    public static void partition(ArrayList<ArrayList<String>> res, String s, int idx, ArrayList<String> curr) {
        if(idx == s.length()) {
            res.add(new ArrayList<String>(curr));
            return;
        }
        String temp = "";

        for (int i=idx;i<s.length();i++) {
            temp += s.charAt(i);
            if(isPalindrome(temp)) {
                curr.add(temp);
                partition(res, s, idx+1, curr);
                curr.remove(curr.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String s) {
        int start = 0, end = s.length()-1;
        while (start < end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "nitin";
        ArrayList<ArrayList<String>> allPart = new ArrayList<>();
        ArrayList<String> currPart = new ArrayList<>();
        partition(allPart, str, 0, currPart);
        System.out.println(allPart);
    }
}
