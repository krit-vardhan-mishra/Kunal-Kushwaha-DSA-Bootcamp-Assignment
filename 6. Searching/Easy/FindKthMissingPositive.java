public class FindKthMissingPositive {
    public static int findKthPositive(int[] arr, int k) {
        int missingCount = 0, current = 1, idx = 0;

        while (missingCount < k) {
            if(idx < arr.length && arr[idx] == current) idx++;
            else {
                missingCount++;
                if(missingCount == k) return current;
            }
            current++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        System.out.println(findKthPositive(arr, 5));
    }

}
