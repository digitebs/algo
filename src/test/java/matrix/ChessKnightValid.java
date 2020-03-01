package matrix;

/*
    cell = a to f, 1-8

Given a position of a knight on the standard chessboard,
 find the number of different moves the knight can perform.
 */
public class ChessKnightValid {
    int chessKnight(String cell) {
        int y = cell.charAt(0)-'a';
        int x = cell.charAt(1)-'1';

        int[] dx= {-1,-2,-2,-1,1,2,2,1};
        int[] dy ={-2,-1,1,2,2,1,-1,-2};

        int count=0;
        for(int i =0; i < 8; i++){
            int x1 = x + dx[i];
            int y1 = y + dy[i];
            if(x1 >=0 && y1 >=0 && x1 < 8 && y1 < 8){
                count++;
            }
        }
        return count;

    }

  public static void main(String[] args) {
    //
      ChessKnightValid ckv = new ChessKnightValid();
      System.out.println(ckv.chessKnight("a1"));
      System.out.println(ckv.chessKnight("c2"));
  }
}
