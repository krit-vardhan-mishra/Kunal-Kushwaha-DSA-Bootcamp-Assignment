public class HappyNumber {

    public static boolean isHappy(int n) {
        int fast = n;
        int slow = n;

        do {
            slow = findSqr(slow);
            fast = findSqr(findSqr(fast));
        } while (slow != fast);

        if(slow == 1) return true;
        else return false;
    }

    private static int findSqr(int num) {
        int ans = 0;

        while (num > 0) {
            int ld = num % 10;
            ans += ld * ld;
            num /= 10;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
    }
}
