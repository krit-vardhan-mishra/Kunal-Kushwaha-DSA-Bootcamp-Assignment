package Easy;
import java.util.Arrays;

public class SmallerNumbersThanCurrent {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] map = new int[101];

        for (int num : nums) {
            map[num]++;
        }

        for (int i = 1; i < map.length; i++) {
            map[i] += map[i-1];
        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                nums[i] = 0;
            } else {
                nums[i] = map[nums[i]-1];
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {8, 1, 2, 2, 3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }
}
