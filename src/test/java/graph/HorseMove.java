package graph;

import java.util.*;

public class HorseMove {
  // Class name must be "Main"
  // Libraries included:
  // json simple, guava, apache commons lang3, junit, jmock

  // Knight moves for 2 squares in one direction and in 1 square in the anothre direction.
  // from 4,4 he can move to 8 different positions? (3,2), (5,6), (3,6) ...
  // What is the shortest PATH from the position A to postion B using ONLY the knight moves.
  // Ex.: (0,0), (0,1) : (0,0) -> (1,2) -> (2,0) -> (0,1);

  // Board size is NxM

  // the complexity is : 8^max(n,m)
  // nxm // no longer cyclic

  // mxm

  static int dy[] = {2, 1, -1, -2, -2, -1, 2, 1};
  static int dx[] = {1, 2, 2, 1, -1, -2, -1, -2};

  static class Path {

    // int[] p = new int[2]; // thsi is optional
    List<int[]> paths;

    // paths.geetLast() <-- current position

    // last one is always the current corrdinate

    Path(List<int[]> paths) {
      // this.p = p;
      this.paths = paths;
    }

    public int[] getLast() {
      return paths.get(this.paths.size() - 1);
    }

    public String toString() {
      String s = "";
      for (int[] p : paths) {
        s += "(" + p[0] + "," + p[1] + ") ->";
      }
      return s;
    }
  }

  // n is teh row
  // m == column

  static Path bfs(int[] a, int[] b, int n, int m, int[][] board) {

    Queue<Path> q = new LinkedList<>();
    int[] p = {a[0], a[1]};
    List<int[]> initPath = new ArrayList<>();
    initPath.add(p);

    q.add(new Path(initPath));
    int count;
    while (!q.isEmpty()) {

      //  int j = q.size();
      // while(j--> 0){
      Path path1 = q.poll();
      //  count++;
      // System.out.println(q.size());
      p = path1.getLast();

      if (p[0] == b[0] && p[1] == b[1]) {
        return path1;
      }

      for (int i = 0; i < 8; i++) {

        int x = p[0] + dx[i]; //
        int y = p[1] + dy[i]; // ouside border

        if (x >= n || y >= m || x < 0 || y < 0 || board[x][y] == 1)
          ;
        else {
          board[x][y] = 1; // means visited
          List<int[]> mypath = new ArrayList<>(path1.paths); // <-- copy  very slow?????/

          int[] coord = new int[] {x, y};
          mypath.add(coord);
          q.offer(new Path(mypath));
        }
      }
      // }
    }

    return null; // empty path
  }

  public static void main(String[] args) {
    System.out.println("Hello, world!");

    int[] a = {0, 0};
    int[] b = {99, 99};

    int n = 100;
    int m = 100;

    int[][] board = new int[n][m];
    System.out.println(bfs(a, b, n, m, board));
  }

  // 8 ^m

  // List<Integer[]> paths

  // bfs

  // B -> 8(moves)

  //   -> 8 * 8 (level1)

  // 8*8*8 (level2)

  /// ... lvel m

  // A - 8(moves) <-- until a postion is found()

}
