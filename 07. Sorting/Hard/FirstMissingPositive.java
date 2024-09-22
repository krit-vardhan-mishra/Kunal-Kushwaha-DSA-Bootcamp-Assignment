
public class FirstMissingPositive {

/*
    // Time Limit Exceeded in Sorting Algorithim 
    public static int firstMissingPositive(int[] nums) {
        int missingNum = 1;

        mergeSort(nums, 0, nums.length);
        for (int num : nums) {
            if(num == missingNum) {
                missingNum++;
            }
        }

        return missingNum;
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if(right -left <= 1) return;

        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid, right);

        merge(nums, left, mid, right);
    }

    public static void merge(int[] nums, int start, int mid, int end) {
        int[] arr = new int[nums.length];
        int i = start, j = mid, k = 0;

        while (i < mid && j < end) {
            if(nums[i] < nums[j]) {
                arr[k++] = nums[i++];
            } else {
                arr[k++] = nums[j++];
            }
        }

        while (i < mid) {
            arr[k++] = nums[i++];
        }

        while (j < end) {
            arr[k++] = nums[j++];
        }

        System.arraycopy(arr, 0, nums, start, k);
    }
*/

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static void swap(int[] nums, int s, int e) {
        int temp = nums[s];
        nums[s] = nums[e];
        nums[e] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(firstMissingPositive(nums));
    }
}
