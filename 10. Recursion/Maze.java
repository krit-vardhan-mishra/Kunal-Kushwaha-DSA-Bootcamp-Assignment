package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Maze {

    public static void main(String[] args) {
        //mazeVoid("", 3, 3);
        //System.out.println();
        //System.out.println(mazeReturn("", 3, 3));
        boolean[][] matrix = new boolean[3][3];
        int[][] path = new int[3][3];

        //mazeMatrixVoid(matrix, "", matrix.length, matrix[0].length);
        mazeMatrixVoid(matrix, "", 0, 0);
        //System.out.println(mazeMatrixReturn(matrix, "", 0, 0));
        //mazeMatrixStepsVoid(matrix, "", 0, 0, path, 1);
        //System.out.println();
        //Map<String, int[][]> res = mazeMatrixStepsReturn(matrix, "", 0, 0, path, 1);
        //res.forEach((key, value) -> System.out.println(key +" : "+Arrays.deepToString(value)));

    }

    public static void mazeVoid(String res, int row, int col) {
        if(row == 1 && col == 1) {
            System.out.print(res+" ");
            return;
        }
        if(row > 0) mazeVoid(res+'R', row-1, col);
        if(col > 0) mazeVoid(res+'D', row, col-1);
    }

    public static ArrayList<String> mazeReturn(String res, int row, int col) {
        if(row == 1 && col == 1) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(res);
            return ans;
        }
        ArrayList<String> first = new ArrayList<>();
        ArrayList<String> second = new ArrayList<>();
        if(row > 0) first.addAll(mazeReturn(res+'R', row-1, col));
        if(col > 0) second.addAll(mazeReturn(res+'D', row, col-1));

        first.addAll(second);
        return first;
    }

    public static void mazeDaigonalVoid(String res, int row, int col) {
        if (row == 1 && col == 1) {
            System.out.print(res+" ");
            return;
        }

        if (row > 1 && col > 1) mazeDaigonalVoid(res + 'D', row-1, col-1);
        if (row > 1) mazeDaigonalVoid(res + 'V', row-1, col);
        if (col > 1) mazeDaigonalVoid(res + 'H', row, col-1);
    }

    public static void mazeMatrixVoid(boolean[][] mat, String res, int row, int col) {
        if(row == mat.length-1 && col == mat[0].length-1) {
            System.out.print(res+" ");
            return;
        }
        if (mat[row][col]) return;

        mat[row][col] = true;
        if(row < mat.length-1) mazeMatrixVoid(mat, res+'D', row+1, col);
        if(col < mat[0].length-1) mazeMatrixVoid(mat, res+'R', row, col+1);
        if(row > 0) mazeMatrixVoid(mat, res+'U', row-1, col);
        if(col > 0) mazeMatrixVoid(mat, res+'L', row, col-1);
        mat[row][col] = false;
    }

    public static ArrayList<String> mazeMatrixReturn(boolean[][] mat, String res, int row, int col) {
        if(row == mat.length-1 && col == mat[0].length-1) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(res);
            return ans;

        }
        if (mat[row][col]) return new ArrayList<String>();

        ArrayList<String> first =  new ArrayList<>();
        ArrayList<String> second =  new ArrayList<>();
        ArrayList<String> third =  new ArrayList<>();
        ArrayList<String> fourth =  new ArrayList<>();
        mat[row][col] = true;
        if(row < mat.length-1) first.addAll(mazeMatrixReturn(mat, res+'D', row+1, col));
        if(col < mat[0].length-1) second.addAll(mazeMatrixReturn(mat, res+'R', row, col+1));
        if(row > 0) third.addAll(mazeMatrixReturn(mat, res+'U', row-1, col));
        if(col > 0) fourth.addAll(mazeMatrixReturn(mat, res+'L', row, col-1));
        mat[row][col] = false;

        first.addAll(second);
        first.addAll(third);
        first.addAll(fourth);

        return first;
    }

    public static void mazeMatrixStepsVoid(boolean[][] mat, String res, int row, int col, int[][] path, int steps) {
        if(row == mat.length-1 && col == mat[0].length-1) {
            path[row][col] = steps;
            System.out.print(res+" : ");
            System.out.println(Arrays.deepToString(path));
            return;
        }
        
        if (mat[row][col]) return;

        mat[row][col] = true;
        path[row][col] = steps;
        if(row < mat.length-1) mazeMatrixStepsVoid(mat, res+'D', row+1, col, path, steps+1);
        if(col < mat[0].length-1) mazeMatrixStepsVoid(mat, res+'R', row, col+1, path, steps+1);
        if(row > 0) mazeMatrixStepsVoid(mat, res+'U', row-1, col, path, steps+1);
        if(col > 0) mazeMatrixStepsVoid(mat, res+'L', row, col-1, path, steps+1);
        mat[row][col] = false;
        path[row][col] = 0;
    }

    public static Map<String, int[][]> mazeMatrixStepsReturn(boolean[][] mat, String res, int row, int col, int[][] path, int steps) {
        Map<String, int[][]> paths = new HashMap<>();

        if (row == mat.length - 1 && col == mat[0].length - 1) {
            path[row][col] = steps;
            int[][] pathCopy = new int[path.length][];
            for (int i = 0; i < path.length; i++) {
                pathCopy[i] = path[i].clone();
            }
            paths.put(res, pathCopy);
            return paths;
        }
        
        if (mat[row][col]) return new HashMap<>();

        mat[row][col] = true;
        path[row][col] = steps;
        if(row < mat.length-1) paths.putAll(mazeMatrixStepsReturn(mat, res+'D', row+1, col, path, steps+1));
        if(col < mat[0].length-1) paths.putAll(mazeMatrixStepsReturn(mat, res+'R', row, col+1, path, steps+1));
        if(row > 0) paths.putAll(mazeMatrixStepsReturn(mat, res+'U', row-1, col, path, steps+1));
        if(col > 0) paths.putAll(mazeMatrixStepsReturn(mat, res+'L', row, col-1, path, steps+1));
        mat[row][col] = false;
        path[row][col] = 0;
        
        return paths;
    }
    
}
  