public class BookAllocation {
    public static int findPages(int[] arr, int m) {
        int start = 0, end = 0;

        for (int i : arr) {
            start = Math.max(i, start);
            end += i;
        }

        int ans = end;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(helper(arr, mid) <= m) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static int helper(int[] arr, int mid) {
        int student = 1, curr = 0;

        for (int i = 0; i < arr.length; i++) {
            curr += arr[i];
            if(curr > mid) {
                student++;
                curr = arr[i];
            }
        }

        return student;
    }
    public static void main(String[] args) {
        int[] arr = {12,34,67,90};
        System.out.println(findPages(arr, 2));
    }   
}
