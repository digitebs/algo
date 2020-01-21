package recursion;

/**
 * @author john.lim
 */
public class WordSearch {
    public boolean exist2(char[][] board, String word, int i, int j) {
        if (word.isEmpty())
            return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        char c = word.charAt(0);
        if (board[i][j] == c) {
            board[i][j] = '0'; //mark it
            String temp = word.substring(1);
            if (exist2(board, temp, i + 1, j)
                    || exist2(board, temp, i, j + 1)
                    || exist2(board, temp, i - 1, j)
                    || exist2(board, temp, i, j - 1)
            ) return true;
            else {
                board[i][j] = c;
                return false;
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist2(board, word, i, j)) return true;
            }
        }
        return false;

    }
}
