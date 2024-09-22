package Hard;

public class GoodArray {
    public static boolean isGoodArray(int[] nums) {
        int gcd = nums[0];

        for (int i = 1; i < nums.length; i++) {
            gcd = gcd(gcd, nums[i]);
        }

        return gcd == 1;
    }

    public static int gcd(int a, int b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        int[] nums = {3,6};
        System.out.println(isGoodArray(nums));
    }
}
