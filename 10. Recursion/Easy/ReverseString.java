public class ReverseString {

    public static void reverseString(char[] s) {
        int start = 0, end = s.length-1;

        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        char[] arr = {'h','e','l','l','o'};

        for (char c : arr) {
            System.out.print(c+" ");    
        }
        System.out.println();
        
        reverseString(arr);
        
        for (char c : arr) {
            System.out.print(c+" ");    
        }
        System.out.println();

    }
}
