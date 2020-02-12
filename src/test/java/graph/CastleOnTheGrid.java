package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
You are given a square grid with some cells open (.) and some blocked (X).
Your playing piece can move along any row or column until it reaches the edge of the grid or a blocked cell.
Given a grid, a start and an end position, determine the number of moves it will take to get to the end position.
 */
public class CastleOnTheGrid {
  /*
     good hard problem of bfs
  */
  static int minimumMoves(String[] strings, int startX, int startY, int goalX, int goalY) {
    // shortest path bfs
    // move till end
    char[][] grid = new char[strings.length][];
    for (int i = 0; i < strings.length; i++) grid[i] = strings[i].toCharArray();

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {startX, startY});
    int level = 0;
    while (!q.isEmpty()) {
      int n = q.size();
      for (int i = 0; i < n; i++) {
        int[] xy = q.poll();
        grid[xy[0]][xy[1]] = '1';
        if (xy[0] == goalX && xy[1] == goalY) return level;
        // System.out.println(Arrays.toString(xy) + " " + level);
        // down
        for (int j = xy[0] + 1; j < grid.length && grid[j][xy[1]] == '.'; j++)
          q.offer(new int[] {j, xy[1]});
        // up
        for (int j = xy[0] - 1; j >= 0 && grid[j][xy[1]] == '.'; j--) q.offer(new int[] {j, xy[1]});
        // left
        for (int j = xy[1] - 1; j >= 0 && grid[xy[0]][j] == '.'; j--) q.offer(new int[] {xy[0], j});
        // right
        for (int j = xy[1] + 1; j < grid[0].length && grid[xy[0]][j] == '.'; j++)
          q.offer(new int[] {xy[0], j});
      }
      // System.out.println("level up");
      level++;
    }
    return level;
  }

  public static void main(String[] args) {
    System.out.println(minimumMoves(new String[] {".X.", ".X.", "..."}, 0, 0, 0, 2));

    System.out.println(
        minimumMoves(
            new String[] {
              ".X..XX...X",
              "X.........",
              ".X.......X",
              "..........",
              "........X.",
              ".X...XXX..",
              ".....X..XX",
              ".....X.X..",
              "..........",
              ".....X..XX"
            },
            9,
            1,
            9,
            6));
  }
}
