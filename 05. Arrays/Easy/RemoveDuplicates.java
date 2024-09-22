package Easy;
public class RemoveDuplicates {
    
    public static int removeDuplicates(int[] nums) {
        int count = 1;
        int j = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,2,3,4,4,4};
        System.out.println(removeDuplicates(arr));
    }
}
