import java.util.Arrays;

public class InsersectionOfTwoArraysOne {

    public static int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if (len1 > len2)
            intersection(nums2, nums1);

        boolean[] hash = new boolean[1001];
        int[] res = new int[len1];

        int idx = 0;

        for (int i = 0; i < len1; i++) {
            hash[nums1[i]] = true;
        }

        for (int i = 0; i < len2; i++) {
            if (hash[nums2[i]]) {
                res[idx++] = nums2[i];
                hash[nums2[i]] = false;
            }
        }

        return Arrays.copyOf(res, idx);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1}, nums2 = {2,2};
        int[] res = intersection(nums1, nums2);

        for (int i : res) {
            System.out.print(i+" ");
        }
    }
}
