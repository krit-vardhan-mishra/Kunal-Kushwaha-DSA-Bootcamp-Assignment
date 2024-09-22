package Easy;
public class DiagonalSum {
    public static int diagonalSum(int[][] matrix) {
        int n = matrix.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += matrix[i][i] + matrix[i][n - i - 1];
        }

        if(n % 2 == 1) sum -= matrix[n/2][n/2];

        return sum;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,1,1},{1,1,1},{1,1,1}};
        System.out.println(diagonalSum(mat));
    }
}
