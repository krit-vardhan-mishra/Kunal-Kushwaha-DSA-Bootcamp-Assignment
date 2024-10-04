package Strings;

class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {

        String smallestStr = strs[0];
        for(int i=1;i<strs.length;i++) {
            smallestStr = commonPrefix(smallestStr, strs[i]);
            if(smallestStr.isBlank()) {
                break;
            }
        }

        return smallestStr;
    }

    private static String commonPrefix(String one, String two) {
        int minLen = Math.min(one.length(), two.length());
        int idx = 0;

        while (idx < minLen && one.charAt(idx) == two.charAt(idx)) {
            idx++;
        }
        return one.substring(0, idx);
    }
}
