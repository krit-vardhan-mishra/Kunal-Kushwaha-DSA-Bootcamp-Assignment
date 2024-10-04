package Recursion;

public class NQueensNKnights {
    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];
        System.out.println("N Queens");
        System.out.println(queens(board, 0));
        System.out.println("N Knights");
        System.out.println(knight(board, 0, 0, 4));
    }

    // N Queens
    public static int queens(boolean[][] board, int row) {
        if(row == board.length) {
            displayQueen(board);
            return 1;
        }

        int count =  0;
        for (int col = 0; col < board.length; col++) {
            if(isSafeQueen(board, row, col)) {
                board[row][col] = true;
                count += queens(board, row+1);
                board[row][col] = false;
            }
        }

        return count;
    }

    private static boolean isSafeQueen(boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if(board[i][col]) return false;
        }

        int maxLeft = Math.min(row, col);
        for(int i = 1; i <= maxLeft; i++) {
            if(board[row-i][col-i]) return false;
        }

        int maxRight = Math.min(row, board.length - col - 1);
        for(int i = 1; i <= maxRight; i++) {
            if(board[row-i][col+i]) return false;
        }

        return true;
    }


    private static void displayQueen(boolean[][] board) {
        for (boolean[] is : board) {
            for (boolean is2 : is) {
                if(is2) System.out.print("Q ");
                else System.out.print("X ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // N Knights
    public static int knight(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            displayKnights(board);
            return 1;
        }

        int count = 0;
        if(row == board.length - 1 && col == board.length) return 1;

        if(col == board.length) {
            count += knight(board, row + 1, 0, knights);
            return 1;
        }

        if(isSafeKnight(board, row, col)) {
            board[row][col] = true;
            count += knight(board, row, col+1, knights-1);
            board[row][col] = false;
        }

        count += knight(board, row, col+1, knights);

        return count;
    }

    private static boolean isSafeKnight(boolean[][] board, int row, int col) {
        if(isValid(board, row - 2, col - 1)) {
            if(board[row - 2][col - 1]) return false;
        }

        if(isValid(board, row - 1, col - 2)) {
            if(board[row - 1][col - 2]) return false;
        }

        if(isValid(board, row - 2, col + 1)) {
            if(board[row - 2][col + 1]) return false;
        }

        if(isValid(board, row - 1, col + 2)) {
            if(board[row - 1][col + 2]) return false;
        }

        return true;
    }

    private static boolean isValid(boolean[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) return true;
        return false;
    }

    private static void displayKnights(boolean[][] board) {
        for (boolean[] is : board) {
            for (boolean is2 : is) {
                if(is2) System.out.print("K ");
                else System.out.print("X ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
