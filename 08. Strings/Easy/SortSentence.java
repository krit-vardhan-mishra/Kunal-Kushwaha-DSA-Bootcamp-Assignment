public class SortSentence {

    public static String sortSentence(String s) {
        String[] arr = s.split(" ");
        String[] ans = new String[arr.length];

        for (String word : arr) {
            int index = Character.getNumericValue(word.charAt(word.length()-1)) - 1;
            ans[index] = word.substring(0, word.length()-1);
        }

        return String.join(" ",ans);
    }

    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";
        System.out.println(sortSentence(s));
    }
}
