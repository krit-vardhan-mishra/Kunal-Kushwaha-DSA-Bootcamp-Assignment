public class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {
        int start = 1, end = (int)1e9;

        while (start < end) {
            int mid = start + (end - start) / 2;
            int totalHrs = 0;

            for (int pile : piles) {
                totalHrs += (pile + mid - 1) / mid;
            }

            if(totalHrs <= h) end = mid;
            else start = mid + 1;
        }

        return start;
    }

    public static void main(String[] args) {
        int[] arr = {3,6,7,11};
        System.out.println(minEatingSpeed(arr, 8));
    }
}
