public class CountGoodNumbers {
    public int mod = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long countEven = (n+1)/2;
        long countOdd = n/2;

        long even = pow(5, countEven);
        long odd = pow(4, countOdd);

        return (int)(even * odd % mod);
    }

    private long pow(long x, long n) {
        if(n == 0) return 1;

        long half = pow(x, n/2);

        if(n % 2 == 0) return (half * half) % mod;
        else return (half * half * x) % mod;
    }
}
