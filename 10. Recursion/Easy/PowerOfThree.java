
public class PowerOfThree {

    public static boolean isPowerOfThree(int n) {
        if (n <= 0)
            return false;
        if (n == 1)
            return true;
        if (n % 3 != 0)
            return false;
        return isPowerOfThree(n / 3);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(0));
        System.out.println(isPowerOfThree(-1));
    }
}