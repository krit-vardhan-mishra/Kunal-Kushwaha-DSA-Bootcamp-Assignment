import java.util.Arrays;

public class IntersectionOfTwoArrayTwo {
    
    public static int[] intersect(int[] num1, int[] num2) {
        int[] freq = new int[1001];
        int[] ans = new int[1001];
        for (int i: num1) {
            freq[i]++;
        }
        
        int size = 0;
        for (int i: num2) {
            if (freq[i]-- > 0) {
                ans[size] = i;
                size++;
            }
        }
        return Arrays.copyOf(ans, size);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1}, nums2 = {2,2};
        int[] res = intersect(nums1, nums2);

        for (int i : res) {
            System.out.print(i+" ");
        }
    }
}
