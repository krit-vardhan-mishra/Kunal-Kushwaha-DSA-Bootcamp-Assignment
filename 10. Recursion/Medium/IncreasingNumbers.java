import java.util.ArrayList;

public class IncreasingNumbers {

    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                ans.add(i);
            }
            return ans;
        }
        ans.addAll(helper(1, 0, n));
        return ans;
    }

    public static ArrayList<Integer> helper(int i, int num, int n) {
        if(n == 0) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(num);
            return ans;
        }
        
        ArrayList<Integer> rs = new ArrayList<>();
        for (int j = i; j <= 9; j++) {
            int number = num * 10 + j;
            rs.addAll(helper(j + 1, number, n - 1));
        }

        return rs;
    }

    public static void main(String[] args) {
        System.out.println(increasingNumbers(1));
        System.out.println(increasingNumbers(2));
    }
}
