public class MaxAndMinRec {

    public static int findMin(int[] arr, int n) {
        if(n == 1) return arr[0];

        return Math.min(arr[n-1] , findMin(arr, n-2));
    }

    public static int findMax(int[] arr, int n) {
        if(n == 1) return arr[0];

        return Math.max(arr[n-1], findMax(arr, n-1));
    }

    public static void main(String[] args) {
        int[] arr = {1,4,3,-5,-4,8,6};
        System.out.println(findMin(arr, arr.length));
        System.out.println(findMax(arr, arr.length));

    }
}
