package Easy;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int check = target - nums[i];
            if(map.containsKey(check)) return new int[]{map.get(check),i};
            map.put(nums[i], i);
        }

        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int[] rs = twoSum(arr, 9);
        System.out.println(rs[0]+" , "+rs[1]);
    }
}
