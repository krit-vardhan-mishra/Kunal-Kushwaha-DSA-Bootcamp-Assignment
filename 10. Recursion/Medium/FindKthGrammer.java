public class FindKthGrammer {

    public static int kthGrammar(int n, int k) {
        if (n == 1) return 0;

        if (k <= (1 << (n - 2))) {
            return kthGrammar(n - 1, k);
        }
        return kthGrammar(n - 1, k - (1 << (n - 2))) ^ 1;
    }


    public static void main(String[] args) {
        System.out.println(kthGrammar(1, 1));
        System.out.println(kthGrammar(3, 3));
    }
}