package Strings;

class MergeStringsAlternately {

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int maxLen = Math.max(word1.length(), word2.length());

        for(int i=0;i<maxLen;i++) {
            if(i<word1.length()) {
                res.append(word1.charAt(i));
            }
            if(i<word2.length()) {
                res.append(word2.charAt(i));
            }
            if(i == word1.length()) {
                res.append(word2.substring(i+1, word2.length()));
                return res.toString();
            }
            if(i == word2.length()) {
                res.append(word1.substring(i+1, word1.length()));
                return res.toString();
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc","pqr"));
        System.out.println(mergeAlternately("ab", "pqrs"));
        System.out.println(mergeAlternately("abcd", "pq"));
    }
}
