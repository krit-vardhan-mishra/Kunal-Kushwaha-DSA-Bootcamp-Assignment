package Strings;

import java.util.ArrayList;
import java.util.List;

class CountMatch {

    // public static int countMatches(List<List<String>> items, String ruleKey,
    // String ruleValue) {
    // int count = 0;
    // int index = -1;
    // switch (ruleKey) {
    // case "type":
    // index = 0;
    // break;
    // case "color":
    // index = 1;
    // break;
    // case "name":
    // index = 2;
    // break;
    // }
    // if (index != -1) {
    // for (List<String> item : items) {
    // if (item.get(index).equals(ruleValue)) {
    // count++;
    // }
    // }
    // }
    // return count;
    // }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        int row = 0;
        while (row < items.size()) {
            switch (ruleKey) {
                case "type":
                    if (items.get(row).get(0).equals(ruleValue)) {
                        count++;
                    }
                    break;
                case "color":
                    if (items.get(row).get(1).equals(ruleValue)) {
                        count++;
                    }
                    break;
                case "name":
                    if (items.get(row).get(2).equals(ruleValue)) {
                        count++;
                    }
                    break;
            }
            row++;
        }
        return count;
    }

    public static void main(String[] args) {
        List<List<String>> lst = new ArrayList<>();
        String rK = "color", rV = "silver";
        System.out.println(countMatches(lst, rK, rV));
    }
}
