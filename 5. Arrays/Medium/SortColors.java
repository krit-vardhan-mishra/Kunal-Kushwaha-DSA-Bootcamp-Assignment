package Medium;

import java.util.Arrays;

public class SortColors {
    public static void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n-1;
        
        while(mid <= high) {
            if(nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if(nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {2,0,0,2,1,0,1,1,1,0,0};
        System.out.println(Arrays.toString(arr));
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
