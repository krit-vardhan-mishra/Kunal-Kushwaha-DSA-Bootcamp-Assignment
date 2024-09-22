package Easy;
public class FindRotation {
    public static boolean findRotation(int[][] mat, int[][] target) {
        int times = 4;
        while (times-- > 0) {
            if(isRotationEqual(mat, target)) return true;
            rotateMatrix(mat);
        }

        return false;
    }

    private static boolean isRotationEqual(int[][] mat, int[][] target) {
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void rotateMatrix(int[][] mat) {
        
        // Transpose of Matrix
        for(int i=0;i<mat.length;i++) {
            for(int j=i+1;j<mat.length;j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        
        // Reverse of Matrix
        for(int i=0;i<mat.length;i++) {
            int left = 0;
            int right = mat[0].length-1;
            
            while(left<right) {
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
            }
        }
    }
    public static void main(String[] args) {
        int[][] mat = {{1,1},{0,1}};
        int[][] target = {{1,1},{1,0}};
        System.out.println(findRotation(mat, target));
    }
}
