public class CountNegative {

    public static int countNegatives(int[][] mat) {
        int rows = 0, cols = mat[0].length-1;
        int countNeg = 0;

        while (rows < mat.length && cols >= 0) {
            if(mat[rows][cols] < 0) {
                countNeg += (mat.length - rows);
                cols--;
            } else {
                rows++;
            }
        }
        return countNeg;
    }

    public static void main(String[] args) {
        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegatives(grid));
    }
}
