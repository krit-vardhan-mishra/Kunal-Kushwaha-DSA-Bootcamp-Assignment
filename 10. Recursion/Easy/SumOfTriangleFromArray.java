
public class SumOfTriangleFromArray {

    public static void sumTriangle(int[] arr) {
        if(arr.length < 1) return;

        int[] temp = new int[arr.length-1];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr[i] + arr[i+1];
        }

        sumTriangle(temp);

        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        sumTriangle(arr);
    }
}