package matrix;


/*
    draw a square in the canvas, with a given rect = x1 y1 x2 y2

Input:
[["a","a","a","a","a","a","a","a"],
 ["a","a","a","a","a","a","a","a"],
 ["a","a","a","a","a","a","a","a"],
 ["b","b","b","b","b","b","b","b"],
 ["b","b","b","b","b","b","b","b"]]
rectangle: [1, 1, 4, 3]

Output:
[["a","a","a","a","a","a","a","a"],
 ["a","*","-","-","*","a","a","a"],
 ["a","|","a","a","|","a","a","a"],
 ["b","*","-","-","*","b","b","b"],
 ["b","b","b","b","b","b","b","b"]]
 */
public class DrawRectangle {
  char[][] drawRectangle(char[][] canvas, int[] rect) {

    // int width = rect[3] - rect[0];
    for (int i = rect[0]; i <= rect[2]; i++) {
      if (i == rect[0]) canvas[rect[1]][i] = '*';
      else if (i == rect[2]) canvas[rect[1]][i] = '*';
      else canvas[rect[1]][i] = '-';
    }
    for (int i = rect[1] + 1; i < rect[3]; i++) {
      canvas[i][rect[0]] = '|';
      canvas[i][rect[2]] = '|';
    }

    for (int i = rect[0]; i <= rect[2]; i++) {
      if (i == rect[0]) canvas[rect[3]][i] = '*';
      else if (i == rect[2]) canvas[rect[3]][i] = '*';
      else canvas[rect[3]][i] = '-';
    }

    return canvas;
  }
}
