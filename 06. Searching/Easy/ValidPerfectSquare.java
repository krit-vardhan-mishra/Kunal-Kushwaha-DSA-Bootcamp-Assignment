public class ValidPerfectSquare {

    public static boolean isPerfectSquare(int x) {
        long start = 1, end = x;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            long val = mid * mid;
            if(val == x) return true;
            else if(val <= x) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(14));
    }
}
