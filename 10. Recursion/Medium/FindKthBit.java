public class FindKthBit {

    public static char findKthBit(int n, int k) {
        if (n == 1) return '0';

        int mid = (int)Math.pow(2, n-1);
        if (k == mid) return '1';
        if (k < mid) return findKthBit(n - 1, k);

        return findKthBit(n - 1, mid * 2 - k) == '0' ? '1' : '0';
    }

    public static void main(String[] args) {
        System.out.println(findKthBit(3, 1));
        System.out.println(findKthBit(4, 11));
    }
}
