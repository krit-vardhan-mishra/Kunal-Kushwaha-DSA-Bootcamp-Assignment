public class DivideChocolate {
    public static int maximizeSweetness(int[] arr, int k) {
        int start = 0, end = 0;
        for(int i : arr) {
            end += i;
        } 

        while (start < end) {
            int mid = start + (end - start) / 2;
            if(func(arr, mid) >= k+1) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    public static int func(int[] arr, int mid) {
        int sum = 0, count = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum >= mid) {
                count++;
                sum = 0;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,1,2,2,1,2,2};
        System.out.println(maximizeSweetness(arr, 2));
    }    
}
