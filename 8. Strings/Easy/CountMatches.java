import java.util.List;

public class CountMatches {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = "type".equals(ruleKey) ? 0 : ("color".equals(ruleKey) ? 1 : 2);
        int count = 0;

        for (List<String> list : items) {
            if(list.get(index).equals(ruleValue)) count++;
        }

        return count;
    }
}
