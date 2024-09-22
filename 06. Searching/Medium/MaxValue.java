public class MaxValue {

    public static int maxValue(int n, int index, int maxSum) {
        maxSum -= n;
        int start = 0, end = maxSum;

        while (start < end) {
            int mid = (end + start) / 2;
            if (sum(n, index, mid) >= maxSum)
                end = mid;
            else
                start = mid + 1;
        }

        return sum(n, index, start) > maxSum ? start : start + 1;
    }

    private static long sum(int n, int index, int x) {
        long start = Math.min(index, x - 1);
        long end = Math.min(n - index, x);
        long startSum = ((x - 1) + (x - 1 - start + 1)) * start / 2;
        long endSum = (x + (x - end + 1)) * end / 2;
        return startSum + endSum;
    }

    public static void main(String[] args) {
        System.out.println(maxValue(6, 1, 10));
    }
}
