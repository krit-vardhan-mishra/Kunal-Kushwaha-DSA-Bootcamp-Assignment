import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {

    public static int[] fairCandySwap(int[] nums1, int[] nums2) {
        int sum1 = 0, sum2 = 0;
        Set<Integer> list = new HashSet<>();

        for (int i : nums1) sum1 += i;
        for (int i : nums2) {
            sum2 += i; 
            list.add(i);
        }

        int diff = (sum1 - sum2) / 2;
        for(int candie : nums1) {
            int target = candie - diff;
            if(list.contains(target)) {
                return new int[]{candie, target};
            }
        }
        
        return null;
    }

    public static void main(String[] args) {
        int[] aliiceSizes = {1,1}, bobSizes = {2,2};
        int[] res = fairCandySwap(aliiceSizes, bobSizes);
        for (int i : res) {
            System.out.print(i+" ");
        }
    }
}
