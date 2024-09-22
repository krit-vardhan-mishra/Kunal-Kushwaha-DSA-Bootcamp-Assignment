package Easy;
public class TransposeMatrix {

    public static int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] trans = new int[col][row];
        
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                trans[j][i] = matrix[i][j];
            }
        }
        
        return trans;
    } 

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        for (int[] is : matrix) {
            for (int is2 : is) {
                System.out.print(is2+" ");
            }
            System.out.println();
        }
        System.out.println();
        
        int[][] result = transpose(matrix);
        for (int[] is : result) {
            for (int is2 : is) {
                System.out.print(is2+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
