package Recursion.Easy;

class ArraySortedOrNotRec {
    public static boolean arraySortedOrNot(int[] arr, int n) {
        if (n == 1 || n == 0)
            return true;
        if (arr[n - 1] < arr[n - 2])
            return false;
        return arraySortedOrNot(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr1 = { 20, 21, 45, 89, 89, 90 };
        System.out.println(arraySortedOrNot(arr1, arr1.length));

        int[] arr2 = { 20, 20, 45, 89, 89, 90 };
        System.out.println(arraySortedOrNot(arr2, arr2.length));

        int[] arr3 = { 20, 20, 79, 98, 99, 97 };
        System.out.println(arraySortedOrNot(arr3, arr3.length));
    }
}
