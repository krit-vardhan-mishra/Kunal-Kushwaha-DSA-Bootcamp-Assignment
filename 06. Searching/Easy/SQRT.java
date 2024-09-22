public class SQRT {

    public static int mySqrt(int x) {
        if(x < 2) return x;

        long start = 1, end = x;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            long val = mid * mid;
            if(val == x) return (int)mid;
            else if(val <= x) start = mid + 1;
            else end = mid - 1;
        }
        return (int)end;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }
}