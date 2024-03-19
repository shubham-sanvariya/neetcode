import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidSudoku {
    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        char[][] arr = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'.', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'8', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        validSudoku.isValidSudoku(arr);
    }

    public boolean isValidSudoku ( char[][] board){
        // Validate rows
        for (int i = 0; i < 9; i++) {
            if (!isValid(board, i, 0, i, 8)) {
                return false;
            }
        }

        // Validate columns
        for (int j = 0; j < 9; j++) {
            if (!isValid(board, 0, j, 8, j)) {
                return false;
            }
        }

        // Validate 3x3 sub-boxes
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValid(board, i, j, i + 2, j + 2)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int startX, int startY, int endX, int endY) {
        boolean[] seen = new boolean[10];
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '0';
                    if (seen[digit]) {
                        return false; // Duplicate found
                    }
                    seen[digit] = true;
                }
            }
        }
        return true;
    }
}