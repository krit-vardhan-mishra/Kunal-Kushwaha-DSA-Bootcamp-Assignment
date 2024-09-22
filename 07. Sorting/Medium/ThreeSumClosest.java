import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int j = i + 1, r = nums.length - 1;

            while (j < r) {
                int currSum = nums[i] + nums[j] + nums[r];
                if (currSum < target) j++;
                else r--;
                if (Math.abs(currSum - target) < Math.abs(sum - target)) sum = currSum;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,0};
        System.out.println(threeSumClosest(arr, 100));
    }    
}