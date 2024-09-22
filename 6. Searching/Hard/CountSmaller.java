import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountSmaller {
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> sortedList = new ArrayList<>();

        for (int i = nums.length-1; i >= 0; i--) {
            int pos = findPosition(sortedList, nums[i]);
            ans.add(pos);
            sortedList.add(pos, nums[i]);
        }

        Collections.reverse(ans);
        return ans;
    }

    private static int findPosition(List<Integer> sortedList, int target) {
        int start = 0, end = sortedList.size();

        while (start < end) {
            int mid = start + (end - start) / 2;

            if(sortedList.get(mid) < target) start = mid + 1;
            else end = mid;
        }

        return start;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,6,1};
        System.out.println(countSmaller(arr));
    }
}
