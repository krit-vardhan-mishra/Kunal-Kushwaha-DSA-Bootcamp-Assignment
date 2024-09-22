import java.util.Arrays;
import java.util.stream.Collectors;

public class LargestNumber {

    public static String largestNumber(int[] nums) {
        String s = Arrays.stream(nums).mapToObj(String :: valueOf).sorted((a, b) -> (b+a).compareTo(a+b)).collect(Collectors.joining(""));
        return s.startsWith("00") ? "0" : s;
    }

    public static void main(String[] args) {
        int[] nums = {10, 2};
        System.out.println(largestNumber(nums));
    }
}
