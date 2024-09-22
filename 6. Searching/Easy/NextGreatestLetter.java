public class NextGreatestLetter {

    public static char nextGreatestLetter(char[] arr, char target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] > target){
                end = mid-1;
            }else {
                start = mid + 1;
            }
        }

       if(start == arr.length){
           return arr[0];
       }
       return arr[start];
    }

    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        System.out.println(nextGreatestLetter(letters, 'a'));
    }
}
