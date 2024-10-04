package Recursion.Easy;

class MaxMinRecursion {

    public static int[] minMaxRecursion(int[] arr, int idx, int min, int max) {
        if (arr.length == 0) return new int[] { -1, -1 };
        if (idx == arr.length) return new int[]{min, max};

        return minMaxRecursion(arr, idx + 1, Math.min(arr[idx], min), Math.max(arr[idx], max));
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 3, -5, -4, 8, 6 };
        int[] res = minMaxRecursion(arr, 0, 0, 0);
        System.out.println(res[0]+" "+res[1]);
    }
}
