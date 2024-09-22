package Easy;

public class NumberOfGoodPairs {
    public static int numIdenticalPairs(int[] nums) {
        int[] map = new int[101];
        int count = 0, max = nums[0];

        for(int num : nums) {
            map[num]++;
            if(num > max) max = num;
        }
        
        for (int i=0; i <= max; i++) {
            if(map[i] > 1) count += (map[i] * (map[i] - 1))/2;
        }

        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        System.out.println(numIdenticalPairs(nums));
    }
}
