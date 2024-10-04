package Strings;

class ReversePrefixWord {

    public static String reversePrefix(String word, char ch) {
        char[] arr = word.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == ch) {
                swap(arr, 0, i);
                break;
            }
        }
        return new String(arr);
    }

    private static void swap(char[] arr, int s, int e) {
        while (s <= e) {
            char temp = arr[e];
            arr[e] = arr[s];
            arr[s] = temp;
            s++;
            e--;
        }
    }

    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        System.out.println(reversePrefix(word, ch));
        System.out.println(reversePrefix("abcd", 'z'));
    }
}
