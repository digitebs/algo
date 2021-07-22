package matrix;

/**
 Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell,
 where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 Example:

 board =
 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]

 Given word = "ABCCED", return true.
 Given word = "SEE", return true.
 Given word = "ABCB", return false.

 @author john.lim
 */
public class WordSearch {
  public boolean exist2(char[][] matrix, String word, int i, int j) {
    if (word.isEmpty()) return true;
    if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) return false;
    char c = word.charAt(0);
    if (matrix[i][j] == c) {
      matrix[i][j] = '0'; // mark it
      String temp = word.substring(1);
      if (exist2(matrix, temp, i + 1, j)
          || exist2(matrix, temp, i, j + 1)
          || exist2(matrix, temp, i - 1, j)
          || exist2(matrix, temp, i, j - 1)) return true;
      else {
        matrix[i][j] = c;
        return false;
      }
    }
    return false;
  }

  public boolean exist(char[][] matrix, String word) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (exist2(matrix, word, i, j)) return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    WordSearch ws = new WordSearch();
    char [][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
    };
    System.out.println(ws.exist(board,"ABCCED"));
    System.out.println(ws.exist(board,"SEE"));
    System.out.println(ws.exist(board,"ABCB"));
  }
}
