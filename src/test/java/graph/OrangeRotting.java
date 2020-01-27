package graph;

import model.Point;

import java.util.ArrayList;
import java.util.LinkedList;


/*
n a given grid, each cell can have one of three values:

the val 0 representing an empty cell;
the val 1 representing a fresh orange;
the val 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.
  If this is impossible, return -1 instead.

 */
public class OrangeRotting {
    /*
        using bfs level node
     */
    public int orangesRotting(int[][] grid) {
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        int n = grid.length, m = grid[0].length;
        LinkedList<Point> q = new LinkedList<>();
        boolean foundFresh = false;
        for(int i=0; i < n ; i++)
            for(int j=0; j < m ; j++){
                if(grid[i][j]==1) foundFresh = true;
                else if(grid[i][j]==2) q.offer(new Point(i, j));
            }

        if(!foundFresh) return 0;

        int level =-1;
        while (!q.isEmpty()) {
            for (Point p : new ArrayList<>(q)) {
                // update to rot
                for (int i = 0; i < 4; i++) { // neighbors or child nodes
                    int a = p.x + dx[i];
                    int b = p.y + dy[i];
                    if (a >= 0 && b >= 0 && a < n && b < m && grid[a][b] == 1 ) {
                        grid[a][b] = 2;
                        q.offer(new Point(a, b));
                    }
                }
                q.poll();
            }
            level++;
        }

        for(int i=0; i < n ; i++){
            for(int j=0; j < m ; j++){
                // System.out.print(grid[i][j]+" ");
                if(grid[i][j]==1)
                    return -1;
            }
            //  System.out.println();
        }
        return level;
    }

    public static void main(String[] args) {
        System.out.println(new OrangeRotting().orangesRotting(new int[][]{
                {2,2},
                {1,1},
                {0,0},
                {2,0}
        }));
    }
}
