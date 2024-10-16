public class MaxConsecutiveOnesTwo {
    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int zerosAllowed = 1;

        while (right < nums.length) {
            if (nums[right++] == 0) zerosAllowed--;
            if (zerosAllowed < 0 && nums[left++] == 0) zerosAllowed++;
        }

        return right - left;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(nums1, 2));
        int[] nums2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes(nums2, 3));
    }
}
