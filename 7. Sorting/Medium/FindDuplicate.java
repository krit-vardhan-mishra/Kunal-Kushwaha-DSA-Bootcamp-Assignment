public class FindDuplicate {

    public static int findDuplicate(int[] nums){
        boolean[] map = new boolean[nums.length + 1];

        for (int num : nums) {
            if (map[num]) {
                return num;
            }
            map[num] = true;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,4};
        System.out.println(findDuplicate(nums));
    }
}
