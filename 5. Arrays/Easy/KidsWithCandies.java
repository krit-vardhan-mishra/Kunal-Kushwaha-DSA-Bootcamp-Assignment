package Easy;
import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> list = new ArrayList<>();
        int max = candies[0];

        for (int candie : candies) {
            max = Math.max(candie, max);
        }

        for (int i = 0; i < candies.length; i++) {
            list.add(candies[i] + extraCandies >= max);
        }

        return list;
    }
    public static void main(String[] args) {
        int[] candies = {2,8,7};
        System.out.println(kidsWithCandies(candies, 1));
    }
}
