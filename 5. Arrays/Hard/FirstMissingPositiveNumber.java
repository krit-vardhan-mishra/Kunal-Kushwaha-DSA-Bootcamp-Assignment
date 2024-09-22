package Hard;

public class FirstMissingPositiveNumber {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+1];

        for (int i = 0; i < n; i++) {
            if(nums[i] > 0 && nums[i] < n+1) arr[nums[i]] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != 1) return i;
        }

        return n+1;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,2,3};
        System.out.println(firstMissingPositive(arr));
    }
}
