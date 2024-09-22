package Easy;
import java.util.Arrays;

public class ConcatenationOfArray {
    public static int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length*2];

        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
            res[nums.length+i] = nums[i];
        }
        
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        System.out.println(Arrays.toString(getConcatenation(nums)));
    }
}
