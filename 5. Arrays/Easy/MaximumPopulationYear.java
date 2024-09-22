package Easy;
public class MaximumPopulationYear {

    public static int maximumPopulation(int[][] logs) {
        int[] ans = new int[101];

        for (int[] i : logs) {
            int birth = i[0] - 1950;
            int death = i[1] - 1950;

            ans[birth]++;
            ans[death]--;
        }

        int curr = 0, maxPopulation = 0, maxIdx = 0;

        for(int i=0; i<101; i++) {
            curr += ans[i];

            if(maxPopulation < curr) {
                maxIdx = i;
                maxPopulation = curr;
            }
        }

        return maxIdx + 1950;
    }

    public static void main(String[] args) {
        int[][] arr = {{1993, 1999},{2000, 2010}};
        System.out.println(maximumPopulation(arr));
    }
}
