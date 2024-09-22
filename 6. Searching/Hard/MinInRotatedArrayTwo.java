
public class MinInRotatedArrayTwo {
    public static int findMin(int[] nums) {
        int start = 0, end = nums.length-1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] == nums[start] && nums[mid] == nums[end]) {
                start++;
                end--;
                continue;
            }

            if(nums[mid] > nums[end]) start = mid + 1;
            else end = mid;
        }

        return nums[end];
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2};
        System.out.println(findMin(arr));

    }
}