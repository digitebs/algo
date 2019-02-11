package graph;

import model.Point;

import java.util.Arrays;
import java.util.LinkedList;

public class BfsMap {
    // solving min or max always requires dynamic programming storing values somewhere
    public static int minpath(int[][] arr) {
        // use bfs
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        int n = arr.length, m = arr[0].length;
        LinkedList<Point> q = new LinkedList<>();
        Point start = new Point(0, 0);
        q.offer(start);
        int[][] dist = new int[n][m];
        for (int[] d : dist) Arrays.fill(d, -1);
        dist[start.x][start.y] = 0;
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) { // neighbors or child nodes
                int a = p.x + dx[i];
                int b = p.y + dy[i];
                if (a >= 0 && b >= 0 && a < n && b < m && dist[a][b] == -1 && arr[a][b] != 0) {
                    dist[a][b] = 1 + dist[p.x][p.y]; //add the value to dist
                    if (arr[p.x][p.y] == 9) return dist[a][b]; // destination found return
                    q.offer(new Point(a, b)); // add this to out dfs
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(minpath(new int[][]{{1, 0, 0}, {1, 0, 0}, {1, 9, 1}}));
    }
}
