public class RecursiveInsertionSort {
    public static void insertionSort(int[] arr, int n) {
        if(n <= 1) return;

        int count = 0;

        for (int i = 1; i < n; i++) {
            if(arr[i] < arr[i-1]) {
                int temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
                count++;
            }
        }

        if(count == 0) return;

        insertionSort(arr, n-1);
    }

    public static void main(String[] args) {
        int[] arr = {1,5,4,2,8};
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        insertionSort(arr, arr.length);
        for(int a : arr) {
            System.out.print(a+" ");
        }
    }
}
