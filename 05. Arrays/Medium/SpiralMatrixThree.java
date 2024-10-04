package Medium;

import java.util.Arrays;

class SpiralMatrix3 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(spiralMatrixIII(1, 4, 0, 0)));
    }
    
    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int totalEle = rows*cols;
        int[][] ans = new int[totalEle][2];
        ans[0] = new int[]{rStart, cStart};

        if(totalEle == 1) return ans;

        int idx = 1;
        for(int k = 1; ; k += 2) {
            int[][] dir = {
                {0, 1, k},
                {1, 0, k},
                {0, -1, k+1},
                {-1, 0, k+1}
            };

            for (int[] is : dir) {
                int rowSteps = is[0], colSteps = is[1], steps = is[2];

                while(steps-- > 0) {
                    rStart += rowSteps;
                    cStart += colSteps;

                    if(rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        ans[idx++] = new int[]{rStart, cStart};
                        if(idx == totalEle) return ans;
                    }
                }
            }
        }
    }
}
