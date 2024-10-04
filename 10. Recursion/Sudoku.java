package Recursion;

public class Sudoku {
    public static void main(String[] args) {
        int[][] board = new int[][]{
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        if (solve(board)) {
            display(board);
        } else {
            System.out.println("Cannot solve");
        }
    }

    public static boolean solve(int[][] board) {
        int row = -1, col = -1;

        boolean isEmpty = true;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if(!isEmpty) break;
        }

        if(isEmpty) return true;

        for(int number = 1; number <= 9; number++) {
            if(isSafe(board, row, col, number)) {
                board[row][col] = number;
                if(solve(board)) return true;
                else board[row][col] = 0;
            }
        }

        return false;

    }

    private static boolean isSafe(int[][] board, int row, int col, int number) {
        for (int i = 0; i < board.length; i++) {
            if(board[row][i] == number) return false;
        }

        for(int[] num : board) {
            if(num[col] == number) return false;
        } 

        int sqrt = (int)(Math.sqrt(board.length));
        int rStart = row - row % sqrt;
        int cStart = col - col % sqrt;

        for(int i = rStart; i < rStart + sqrt; i++) {
            for (int j = cStart; j < cStart + sqrt; j++) {
                if(board[i][j] == number) return false;
            }
        }

        return true;

    }

    public static void display(int[][] board) {
        for (int[] is : board) {
            for(int is2 : is) {
                System.out.print(is2+" ");
            }
            System.out.println();
        }
    }

}
