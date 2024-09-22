public class SumOfNaturalNum {
    public static int rec(int n) {
        if(n <= 1) return n;
        return n + rec(n-1);
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println(rec(n));
    }
}
