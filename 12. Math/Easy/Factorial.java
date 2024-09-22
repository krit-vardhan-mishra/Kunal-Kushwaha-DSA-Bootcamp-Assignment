public class Factorial {
    public static long factorial(int N){
        // code here
        if(N == 1) return 1;
        return N * factorial(N - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(18));
    }
}
