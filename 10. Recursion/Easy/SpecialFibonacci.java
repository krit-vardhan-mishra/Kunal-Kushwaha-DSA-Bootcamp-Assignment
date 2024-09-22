public class SpecialFibonacci {
    public static int fib(int a, int b, int n) {
        if(n % 3 == 1) return b;
        if(n % 3 == 0) return a;
        return a^b;
    }

    public static void main(String[] args) {
        System.out.println(fib(86, 77, 15));
        System.out.println(fib(93, 35, 86));
        System.out.println(fib(92, 49, 21));
        System.out.println(fib(62, 27, 90));
        System.out.println(fib(12, 33, 11));
    }
}
