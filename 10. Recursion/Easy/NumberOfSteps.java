package Recursion.Easy;

class NumberOfSteps {
    public static int numberOfSteps(int num) {
        return helper(num, 0);
    }

    public static int helper(int n, int cnt) {
        if(n == 0) return cnt;
        if(n % 2 == 0) return helper(n/2, cnt+1);
        else return helper(n-1, cnt+1);
    }

    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
        System.out.println(numberOfSteps(8));
        System.out.println(numberOfSteps(123));
    }
}
