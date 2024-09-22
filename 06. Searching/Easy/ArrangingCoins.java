public class ArrangingCoins {

    public static int arrangeCoins(int n) {
        long start = 1, end = n;
        long count = 0;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            long sum = mid * (mid + 1) / 2;

            if(sum == n) return (int) mid;
            else if(sum < n) {
                count = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return (int)count;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
        System.out.println(arrangeCoins(8));
    }
}
