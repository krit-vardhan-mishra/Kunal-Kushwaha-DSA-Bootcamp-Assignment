import java.util.Arrays;

public class MaxProductOfThree {

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int a = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int b = nums[n - 1] * nums[0] * nums[1];
        return Math.max(a, b);
    }

    public static void main(String[] args) {
        int[] arr = {-100,-98,-1,2,3,4};
        System.out.println(maximumProduct(arr));
    }
}
