public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 3 };
        System.out.println(majorityElement(arr));
    }

    public static int majorityElement(int[] nums) {
        int element = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                element = nums[i];
            }
            if (nums[i] == element) {
                count++;
            } else {
                count--;
            }
        }
        return element;
    }
}
