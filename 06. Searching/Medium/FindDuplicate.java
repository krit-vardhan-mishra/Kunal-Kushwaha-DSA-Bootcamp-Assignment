public class FindDuplicate {

    public static int findDuplicates(int[] nums) {
        boolean[] map = new boolean[nums.length+1];

        for (int i : nums) {
            if(map[i]) return i;
            map[i] = true;
        }
        
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {3,3,3,3,3};
        System.out.println(findDuplicates(arr));
    }
}
