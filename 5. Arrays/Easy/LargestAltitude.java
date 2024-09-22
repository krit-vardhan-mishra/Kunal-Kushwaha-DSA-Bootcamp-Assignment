package Easy;
public class LargestAltitude {
    public static int largestAltitude(int[] gain) {
        int max = 0;
        int[] ans = new int[gain.length+1];
        ans[0] = 0;

        for (int i = 1; i < ans.length; i++) {
            ans[i] = gain[i-1] + ans[i-1];
            if(max < ans[i]) {
                max = ans[i];
            }
        }

        return max;
    }
    public static void main(String[] args) {
        int[] gain = {-5,1,5,0,-1};
        System.out.println(largestAltitude(gain));
    }
}
