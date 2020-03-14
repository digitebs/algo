package matrix;

import java.util.*;


/*
    find all position where queen is not able to attack.
     _______________
   8|      .       .|
   7|.     .     .  |
   6|  .   .   .    |
   5|    . . .      |
   4|. . . q . . . .|
   3|    .   .      |
   2|  .       .    |
   1|.           .  |
    +---------------+
     a b c d e f g h


    Input: q = "d4"
    Output:
    ["a2", "a3", "a5", "a6", "a8",
     "b1", "b3", "b5", "b7", "b8",
     "c1", "c2", "c6", "c7", "c8",
     "e1", "e2", "e6", "e7", "e8",
     "f1", "f3", "f5", "f7", "f8",
     "g2", "g3", "g5", "g6", "g8",
     "h1", "h2", "h3", "h5", "h6", "h7"]
 */
public class ChessQueen {
    String[] chessQueen(String q) {
        int[] dx = {1,0,-1,0,1,1,-1,-1};
        int[] dy = {0,1,0,-1,-1,1,1,-1};
        // 8 loops

        int x = q.charAt(1) - '1';
        int y = q.charAt(0) - 'a';
        int x1 = x, y1 = y, d = 0;
        Set<String> hs = new HashSet<>();
        hs.add("" + x1+y1);
        while(d < 8){
            x1 = x1 + dx[d];
            y1 = y1 + dy[d];
            if(x1 >=0 && y1 >= 0 && x1 < 8 && y1 < 8){
                hs.add("" +x1+y1);
            }else{
                d++;
                x1 = x;
                y1 = y;
            }
        }
        List<String> res = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j <8; j++){
                if(!hs.contains(""+i+j)){
                    res.add(""+ (char)('a'+ j)+(i+1) );
                }
            }
        }
        return res.stream().sorted().toArray(String[]::new);
    }

  public static void main(String[] args) {
    //

      ChessQueen cq = new ChessQueen();
      System.out.println(Arrays.toString(cq.chessQueen("d4")));
      System.out.println(Arrays.toString(cq.chessQueen("a2")));

  }
}
