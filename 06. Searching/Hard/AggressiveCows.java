import java.util.Arrays;

public class AggressiveCows {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls); 
        int start = 1, end = stalls[stalls.length-1] - stalls[0];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(helper(stalls, mid) >= k) start = mid + 1;
            else end = mid - 1;
        }
        return end;
    }

    private static int helper(int[] arr, int ways) {
        int cowsCouont = 1, last = arr[0];

        for(int i=1;i<arr.length;i++) {
            if(arr[i] - last >= ways) {
                cowsCouont++;
                last = arr[i];
            }
        }
        return cowsCouont;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,8,4,9};
        System.out.println(aggressiveCows(arr, 3));
    }
}
