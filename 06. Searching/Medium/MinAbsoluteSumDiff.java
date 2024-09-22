import java.util.Arrays;

public class MinAbsoluteSumDiff {
    
    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {

        int[] num = nums1.clone();
        Arrays.sort(num);
        int val = (int)1e9 + 7;

        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum =(sum + Math.abs(nums1[i] - nums2[i])) % val;
        }

        int best = 0;
        for(int i = 0;i < num.length; i++) {
            int diff1 = Math.abs(nums1[i] - nums2[i]);
            int diff2 = Integer.MAX_VALUE;
            int j = search(num, nums2[i]);
            if(j < num.length) {
                diff2 = Math.min(diff2, Math.abs(num[j] - nums2[i]));
            }
            if(j > 0) {
                diff2 = Math.min(diff2, Math.abs(num[j-1]- nums2[i]));
            }
            best = Math.max(best, diff1 - diff2);
        }

        return (sum - best + val) % val; 
    }

    public static int search(int[] nums, int n) {
        int start = 0, end = nums.length-1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] >= n) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,7,5}, arr2 = {2,3,5};
        System.out.println(minAbsoluteSumDiff(arr1, arr2));
    }
}
