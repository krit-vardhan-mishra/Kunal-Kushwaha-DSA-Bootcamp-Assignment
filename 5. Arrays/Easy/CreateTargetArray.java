package Easy;
import java.util.ArrayList;
import java.util.Arrays;

public class CreateTargetArray {
    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] res = new int[nums.length];
        ArrayList<Integer> target = new ArrayList<>();

        for (int i = 0; i < index.length; i++) {
            target.add(index[i], nums[i]);
        }

        for (int i = 0; i < index.length; i++) {
            res[i] = target.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,0};
        int[] index = {0,1,2,3,0};
        System.out.println(Arrays.toString(createTargetArray(nums, index)));
    }
}
