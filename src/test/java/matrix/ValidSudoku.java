package matrix;

import java.util.HashSet;

public class ValidSudoku {
  static boolean isValidSudoku(char[][] board) {
    // add it in hset
    for (int i = 0; i < board.length; i++) {
      HashSet<Character> hs = new HashSet<>();
      HashSet<Character> vs = new HashSet<>();
      HashSet<Character> ms = new HashSet<>();
      for (int j = 0; j < board[0].length; j++) {
         System.out.println((i / 3)*3 + j / 3 + " " + ((i % 3) * 3 + j % 3));

        char h = board[i][j];
        char v = board[j][i];
        char m = board[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3];
        if (h != '.' && !hs.add(h) || v != '.' && !vs.add(v) || m != '.' && !ms.add(m))
          return false;
      }
       System.out.println();
    }

    return true;
  }
/*
[[".",".",".",".","5",".",".","1","."],
[".","4",".","3",".",".",".",".","."],
[".",".",".",".",".","3",".",".","1"],
["8",".",".",".",".",".",".","2","."],
[".",".","2",".","7",".",".",".","."],
[".","1","5",".",".",".",".",".","."],
[".",".",".",".",".","2",".",".","."],
[".","2",".","9",".",".",".",".","."],
[".",".","4",".",".",".",".",".","."]]
 */
  public static void main(String[] args) {
    //
    System.out.println(
        ValidSudoku.isValidSudoku(
            new char[][] {
              {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
              {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
              {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
              {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
              {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
              {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
              {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
              {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
              {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
            }));

    System.out.println(
        ValidSudoku.isValidSudoku(
            new char[][] {
              {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
              {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
              {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
              {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
              {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
              {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
              {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
              {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
              {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
            }));
  }
}
