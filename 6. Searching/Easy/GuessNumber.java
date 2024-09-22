public class GuessNumber {
    public static int guessNumber(int n) {
        int start = 1, end = n;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if(guess(mid) <= 0) end = mid;
            else start = mid + 1;
        }

        return start;
    }
    public static void main(String[] args) {
        System.out.println(guessNumber(10));
        System.out.println(guessNumber(1));
        System.out.println(guessNumber(2));
    }
}
