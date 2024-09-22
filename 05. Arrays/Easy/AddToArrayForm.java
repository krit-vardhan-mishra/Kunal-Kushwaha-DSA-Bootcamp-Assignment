package Easy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayForm {

    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>(num.length);
        int carry = 0, i = num.length-1;

        while (i >= 0 || k > 0) {
            if(i >= 0) {
                carry += num[i];
                i--;
            }

            carry += k % 10;
            k /= 10;
            ans.add(carry % 10);
            carry /= 10;
        }

        if(carry > 0) {
            ans.add(carry);
        }

        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] num = {1,2,0,0};
        System.out.println(addToArrayForm(num, 34));
    }
}
