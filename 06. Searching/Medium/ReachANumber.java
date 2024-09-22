public class ReachANumber {
    public static int reachNumber(int target) {
        if(target < 0) return reachNumber(-target);
        
        int ans = 0, start = 0, end = target;

        while (start < end) {
            start += ++ans;
        }
        while ((start-end) % 2 == 1) {
            start += ++ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(reachNumber(2));
    }
}
