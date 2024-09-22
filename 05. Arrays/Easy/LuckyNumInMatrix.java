package Easy;
import java.util.ArrayList;
import java.util.List;

public class LuckyNumInMatrix {

    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        for(int i=0;i<matrix.length;i++) {
            
            int min = matrix[i][0];
            int minIdx = 0;
            
            for(int j=1;j<matrix[0].length;j++) {
                if(matrix[i][j] < min) {
                    min = matrix[i][j];
                    minIdx = j;
                }
            }
            
            boolean lucky = true;
            for(int k=0;k<matrix.length;k++) {
                if(matrix[k][minIdx] > min) {
                    lucky = false;
                    break;
                }
            }
            
            if(lucky) {
                result.add(min);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
        System.out.println(luckyNumbers(matrix));
    }
}
