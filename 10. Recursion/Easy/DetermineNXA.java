package Recursion.Easy;

class DetermineNXA {
    public static int findExponent(int n, int a) {
        if(n == 1) return 0;
        if(n < a) return -1;
        int result = findExponent(n/a, a);
        if(result != -1) return result + 1;
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(findExponent(8, 2));
    }    
}
