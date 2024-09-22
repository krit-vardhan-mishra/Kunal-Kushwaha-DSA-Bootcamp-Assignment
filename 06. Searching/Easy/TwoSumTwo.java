public class TwoSumTwo {

    public static int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length-1;

        while (i < j) {
            int val = nums[i]+nums[j];
            if(val == target) {
                return new int[]{i+1, j+1};
            } else if(val < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        System.out.println(twoSum(arr, 9));
    }
}
