package Medium;

public class SearchRange {

    public static int[] searchRange(int[] nums, int target) {
        int first = firstOcc(nums, target);
        if(first == -1) return new int[]{-1,-1};
        int last = lastOcc(nums, target);

        return new int[]{first, last};
    }

    public static int firstOcc(int[] arr, int target) {
        int ans = -1, start = 0, end = arr.length-1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[mid] == target) {
                ans = mid;
                end = mid - 1;
            }
            else if(arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }

        return ans;
    }

    public static int lastOcc(int[] arr, int target) {
        int ans = -1, start = 0, end = arr.length-1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[mid] == target) {
                ans = mid;
                start = mid + 1;
            }
            else if(arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,8,9,10};
        int[] res = searchRange(arr, 8);

        for (int i : res) {
            System.out.print(i+" ");
        }
    }
}
