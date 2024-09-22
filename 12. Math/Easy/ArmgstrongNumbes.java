public class ArmgstrongNumbes {

    public static boolean armstrongNumber(int n) {
        int original = n;
        int ans = 0;

        while (n != 0) {
            int ld = n % 10;
            ans = ans + ld * ld *ld;
            n /= 10;
        }

        return ans == original;
    }

    public static void main(String[] args) {
        System.out.println(armstrongNumber(153));
    }
}
