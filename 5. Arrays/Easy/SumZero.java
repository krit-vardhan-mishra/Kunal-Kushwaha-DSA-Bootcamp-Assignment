package Easy;
public class SumZero {

    public static int[] sumZero(int n) {
        if(n == 1) return new int[]{0};

        int[] ans = new int[n];
        for (int i = 1; i < n; i++) {
            ans[i] = i;
        }
        ans[0] = -(n * (n - 1)) / 2;

        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = sumZero(5);
        for (int i : arr1) {
            System.err.print(i+" ");
        }
        System.out.println();

        int[] arr2 = sumZero(3);
        for (int i : arr2) {
            System.err.print(i+" ");
        }
        System.out.println();

        int[] arr3 = sumZero(1);
        for (int i : arr3) {
            System.err.print(i+" ");
        }
        System.out.println();
    }
}
