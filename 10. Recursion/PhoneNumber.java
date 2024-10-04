package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class PhoneNumber {

    // Optimized
    // public static List<String> dailPad(String digits) {
    // if(digits.isEmpty()) return new ArrayList<String>();
    // Map<Character, String> map = new HashMap<>();
    // map.put('2', "abc");
    // map.put('3', "def");
    // map.put('4', "ghi");
    // map.put('5', "jkl");
    // map.put('6', "mno");
    // map.put('7', "pqrs");
    // map.put('8', "tuv");
    // map.put('9', "wxyz");

    // System.out.println(map.get('1'));

    // List<String> combinations = new ArrayList<>();
    // permutation(combinations, digits, "", map);
    // return combinations;
    // }

    // public static void permutation(List<String> ans, String str, String p,
    // Map<Character, String> map) {
    // if(str.isEmpty()) {
    // ans.add(p);
    // return;
    // }
    // char ch = str.charAt(0);
    // String letters = map.get(ch);
    // if (letters == null) return;
    // for (char letter : letters.toCharArray()) {
    // permutation(ans, str.substring(1), p+letter, map);
    // }
    // }

    // public static void main(String[] args) {
    // String s = "";
    // System.out.println(dailPad(s));
    // }
    // [aj, ak, al, bj, bk, bl, cj, ck, cl]

    public static String dailPad(int n) {
        Map<Integer, String> map = new HashMap<>();
        String s = "abc";
        map.put(0, "___");
        map.put(1, s);
        for (int i = 2; i <= 9; i++) {
            s = incrementString(s, 3);
            map.put(i, s);
        }
        return map.get(n);
    }

    public static String incrementString(String str, int num) {
        StringBuilder res = new StringBuilder();
        for (char c : str.toCharArray()) {
            char ch = (char) (c + num);
            if (ch > 'z') {
                return res.toString();
            }
            res.append(ch);
        }
        return res.toString();
    }

    public static List<String> permutation(String p, String str) {
        if (str.isEmpty()) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        ArrayList<String> res = new ArrayList<>();
        char ch = str.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i);
            res.addAll(permutation(f + ch + s, str.substring(1)));
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "25";
        String[] sArr = new String[s.length()];
        int i = 0;
        for (char c : s.toCharArray()) {
            String test = dailPad(Character.getNumericValue(c));
            sArr[i] = test;
            i++;
        }
        Map<Integer, List<String>> fin = new HashMap<>();
        for (int j = 0; j < sArr.length; j++) {
            fin.put(Character.getNumericValue(s.charAt(j)), permutation("", sArr[j]));
        }
        fin.forEach((key, value) -> System.out.println(key + " : " + value));
    }

}