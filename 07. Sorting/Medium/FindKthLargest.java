public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        mergeSort(nums, 0, nums.length);

        return nums[nums.length - k];
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (right - left <= 1) return;

        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid, right);

        merge(nums, left, mid, right);
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int[] arr = new int[end - start];
        int i = start, j = mid, k = 0;

        while (i < mid && j < end) {
            if (nums[i] < nums[j]) {
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

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums, 4));
    }

}
