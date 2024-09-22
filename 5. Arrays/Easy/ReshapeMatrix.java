package Easy;
public class ReshapeMatrix {

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;

        if(m*n != r*c) return mat;

        int[][] res = new int[r][c];
        int curRow = 0, currCol = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(currCol == c) {
                    curRow++;
                    currCol = 0;
                }
                res[curRow][currCol] = mat[i][j];
                currCol++;
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2},{3,4}};
        int[][] res = matrixReshape(mat, 1, 4);
        for (int[] is : res) {
            for (int is2 : is) {
                System.out.print(is2+" ");
            }
            System.out.println();
        }
    }
}
