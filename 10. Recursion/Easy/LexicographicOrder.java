package Recursion.Easy;

import java.util.ArrayList;

class LexicographicOrder {

    public static ArrayList<String> powerSet(String s, String res) {
        if(s.isEmpty()) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(res);
            return ans;
        } 
        char ch = s.charAt(0);
        ArrayList<String> l = powerSet(s.substring(1), res+ch);
        ArrayList<String> r = powerSet(s.substring(1), res);
        l.addAll(r);

        return l;
    }

    public static void main(String[] args) {
        String s = "cab";
        System.out.println(powerSet(s, ""));
    }
}
