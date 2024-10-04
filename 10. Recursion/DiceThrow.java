package Recursion;

import java.util.ArrayList;

public class DiceThrow {
    
    public static void main(String[] args) {
        diceThrownVoid("",4);
        System.out.println();
        System.out.println(diceThrownReturn("",4));
        diceThrownFace("", 0, 8);
    }

    public static void diceThrownVoid(String res, int n) {
        if(n == 0) {
            System.out.print(res+" ");
            return;
        }

        for (int i = 1; i <= 6 && i <= n ; i++) {
            diceThrownVoid(res+i, n-i);
        }
    }
    public static ArrayList<String> diceThrownReturn(String res, int n) {
        if(n == 0) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(res);
            return ans;
        }

        ArrayList<String> ans = new ArrayList<>();

        for (int i = 1; i <= 6 && i <= n ; i++) {
            ans.addAll(diceThrownReturn(res+i, n-i));
        }

        return ans;
    }

    // Face means sides of dice.
    public static void diceThrownFace(String res, int n, int face) {
        if(n == 0) {
            System.out.println(res);
            return;
        }

        for (int i = 1; i <= face && i <= n ; i++) {
            diceThrownFace(res+i, n-i, face);
        }
    }

}
