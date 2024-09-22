package Easy;
public class FindNumbersWithEvenNumber {
    public static int findNumbers(int[] nums){
        int totalContain = 0;
        for(int i=0;i<nums.length;i++) {
            int n = nums[i];
            int count = 0;
            while(n>0) {
                n /= 10;
                count++;
            }
            if(count % 2 == 0) totalContain++;
        }
        return totalContain;
    }

    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        System.out.println(findNumbers(nums));
    }
}
