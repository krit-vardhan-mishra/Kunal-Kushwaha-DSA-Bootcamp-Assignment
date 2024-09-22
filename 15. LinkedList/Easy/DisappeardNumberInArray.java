
public class DisappeardNumberInArray {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        
        for (final int num : nums) {
          final int index = Math.abs(num) - 1;
          nums[index] = -Math.abs(nums[index]);
        }

        for (int i = 0; i < nums.length; ++i)
          if (nums[i] > 0)
            ans.add(i + 1);

        return ans;
    }
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,0};
        System.out.println(findDisappearedNumbers(arr));
    }

}