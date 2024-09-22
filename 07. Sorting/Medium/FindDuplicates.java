import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {

    public static List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n+1];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr[nums[i]]++;
        }

        for (int i = 0; i < n+1; i++) {
            if(arr[i] > 1) {
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(findDuplicates(nums));
    }
}
