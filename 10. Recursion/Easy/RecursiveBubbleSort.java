public class RecursiveBubbleSort {
    public static void bubbleSort(int[] arr, int n) {
        if(n <= 1) return;

        int count = 0;

        for (int i = 0; i < n-1; i++) {
            if(arr[i] > arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                count++;
            }
        }

        if(count == 0) return;

        bubbleSort(arr, n-1);
    }

    public static void main(String[] args) {
        int[] arr = {1,5,4,2,8};
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        bubbleSort(arr, arr.length);
        for(int a : arr) {
            System.out.print(a+" ");
        }
    }
}
