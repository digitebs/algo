package matrix;

/** @author john.lim */
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
}
