package Medium;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = 1;
        }

        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            ans[i] *= left;
            left *= nums[i];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= right;
            right *= nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};

        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        
        int[] res = productExceptSelf(arr);

        for (int i : res) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
