import java.util.Arrays;

public class SpecialArray {

    public static int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            int ele = lowerBound(nums, i);
            if (nums.length - ele == i)
                return i;
        }
        return -1;
    }

    public static int lowerBound(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 5 };
        System.out.println(specialArray(nums));
    }
}
