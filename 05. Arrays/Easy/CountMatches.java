package Easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountMatches {
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = "type".equals(ruleKey) ? 0 : ("color".equals(ruleKey) ? 1 : 2);
        int count = 0;

        for (List<String> list : items) {
            if(list.get(index).equals(ruleValue)) count++;
        }

        return count;
    }
    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();
        items.add(Arrays.asList("phone","blue","pixel"));
        items.add(Arrays.asList("computer","silver","lenove"));
        items.add(Arrays.asList("phone","gold","iphone"));

        System.out.println(countMatches(items, "color", "silver"));
        System.out.println(countMatches(items, "type", "phone"));
    }
}
