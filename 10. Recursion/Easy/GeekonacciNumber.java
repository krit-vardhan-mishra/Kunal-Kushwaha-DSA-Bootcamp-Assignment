public class GeekonacciNumber {
    public static int fib(int a, int b, int c, int n) {
        if(n == 1) return 1;
        if(n == 2) return b;
        if(n == 3) return c;
        return fib(a, b, c, n-1) + fib(a, b, c, n-2) + fib(a, b, c, n-3);
    }
    
    public static void main(String[] args) {
        System.out.println(fib(1, 3, 2, 4));
        System.out.println(fib(1, 3, 2, 5));
        System.out.println(fib(1, 3, 2, 6));
    }
}
