package Easy;

import java.util.Arrays;

class FlippingAnImage {
    public static int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int temp = image[i][left] ^ 1;
                image[i][left] = image[i][right] ^ 1;
                image[i][right] = temp;
                left++;
                right--;
            }
        }
        return image;
    }
    public static void main(String[] args) {
        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] result = flipAndInvertImage(image);
        for (int[] i : result) {
            System.out.println(Arrays.toString(i));
        }
    }
}