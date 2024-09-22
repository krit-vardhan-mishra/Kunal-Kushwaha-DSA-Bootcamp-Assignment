public class SortArrayByParity {

    public static int[] sortArrayByParity(int[] nums) {
        if (nums.length == 1) return nums;

        int i = 0, j = nums.length - 1;
        
        while (i < j) {
            if (nums[i] % 2 == 1) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            } else i++;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        int[] res = sortArrayByParity(nums);

        for (int i : res) {
            System.out.print(i+" ");
        }
    }
}
