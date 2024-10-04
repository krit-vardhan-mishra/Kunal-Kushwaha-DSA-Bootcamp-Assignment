package Strings;

class ReverseWords {

    /*
     * public String reverseWords(String s) {
     * StringBuilder res = new StringBuilder();
     * String[] arr = s.split(" ");
     * for(int i=0;i<arr.length;i++) {
     * String str = arr[i];
     * for(int j=str.length()-1;j>=0;j--) {
     * res.append(str.charAt(j));
     * }
     * if(i != arr.length-1) {
     * res.append(" ");
     * }
     * }
     * return res.toString();
     * }
     */

    public static String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        int start = 0, n = s.length();

        while (start < n) {
            int end = start;

            while (end < n && s.charAt(end) != ' ')
                end++;

            for (int i = end - 1; i >= start; i--)
                res.append(s.charAt(i));

            if (end < n)
                res.append(" ");

            start = end + 1;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        System.out.println(reverseWords(str));
    }
}
