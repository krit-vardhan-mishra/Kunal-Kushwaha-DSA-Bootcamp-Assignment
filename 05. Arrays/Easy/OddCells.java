package Easy;
public class OddCells {
    public static int oddCells(int m, int n, int[][] indices) {
        int[][] ans = new int[m][n];
        for(int i = 0; i < indices.length; i++) {
            for(int j = 0; j < m;j++) {
                ans[j][indices[i][1]]++;
            }
            for(int j = 0; j < n;j++) {
                ans[indices[i][0]][j]++;
            }
        }
        int count = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(ans[i][j]%2!=0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] indices = {{1,1},{0,0}};
        int m = 2, n = 2;
        System.out.println(oddCells(m, n, indices));
    }
}
