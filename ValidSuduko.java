import java.util.Arrays;
import java.util.HashSet;

public class ValidSuduko {
    public static boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (char[] x : board) {
            char[] tempArr = new char[n];
            for (int i = 0; i < n; i++) {
                tempArr[i] = x[i];
            }

            Arrays.sort(tempArr);

            for (int i = 0; i < tempArr.length - 1; i++) {
                if (tempArr[i] == '.') {
                    continue;
                }
                int curr = tempArr[i] - '0';
                if (curr < 0 || curr > 9) {
                    return false;
                }

                if (curr == tempArr[i + 1] - '0') {
                    return false;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < m; j++) {
                if (board[j][i] == '.') {
                    continue;
                }

                if (board[j][i] - '0' < 0 || board[j][i] - '0' > 9) {
                    return false;
                }
                char curr = board[j][i];
                if (set.contains(board[j][i])) {
                    return false;
                }
                set.add(curr);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Test case 1: Valid Sudoku
        char[][] board1 = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '6', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        System.out.println(isValidSudoku(board1));
    }
}
