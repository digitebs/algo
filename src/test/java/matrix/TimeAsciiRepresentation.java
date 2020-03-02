package matrix;

public class TimeAsciiRepresentation {
    char[][] zero = {
            {'*','*','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','*','*'}
    };

    char[][] one = {
            {'.', '*', '.'},
            {'.', '*', '.'},
            {'.', '*', '.'},
            {'.', '*', '.'},
            {'.', '*', '.'},
            {'.', '*', '.'},
            {'.', '*', '.'},
            {'.', '*', '.'},
            {'.', '*', '.'},
            {'.', '*', '.'},
            {'.', '*', '.'},
            {'.', '*', '.'},
            {'.', '*', '.'},
            {'.', '*', '.'},
            {'.', '*', '.'},
            {'.', '*', '.'},
            {'.', '*', '.'}
    };
    char[][] two = {
            {'*','*','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'*','*','*'},
            {'*','.','.'},
            {'*','.','.'},
            {'*','.','.'},
            {'*','.','.'},
            {'*','.','.'},
            {'*','.','.'},
            {'*','.','.'},
            {'*','*','*'}
    };

    char[][] three = {
            {'*','*','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'*','*','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'*','*','*'}
    };

    char[][] four = {
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','*','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'}
    };


    char[][] five =  {
            {'*','*','*'},
            {'*','.','.'},
            {'*','.','.'},
            {'*','.','.'},
            {'*','.','.'},
            {'*','.','.'},
            {'*','.','.'},
            {'*','.','.'},
            {'*','*','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'*','*','*'}
    };

    char[][] six = {
            {'*','*','*'},
            {'*','.','.'},
            {'*','.','.'},
            {'*','.','.'},
            {'*','.','.'},
            {'*','.','.'},
            {'*','.','.'},
            {'*','.','.'},
            {'*','*','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','*','*'}
    };

    char[][] seven ={
            {'*','*','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'}
    };


    char[][] eight = {
            {'*','*','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','*','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','*','*'}
    };
    char[][] nine = {
            {'*','*','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','.','*'},
            {'*','*','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'.','.','*'},
            {'*','*','*'}
    };



    boolean equals(char[][]a, char[][] b, int offset){
        for(int i =0;i < 17; i++){
            for(int j=0; j <3; j++){
                if(a[i][offset+j] != b[i][j]) return false;
            }
        }
        return true;
    }

    int equalsAll(char[][]a, int offset){
        if (equals(a,zero,offset)) return 0;
        if (equals(a,one,offset)) return 1;
        if (equals(a,two,offset)) return 2;
        if (equals(a,three,offset)) return 3;
        if (equals(a,four,offset)) return 4;
        if (equals(a,five,offset)) return 5;
        if (equals(a,six,offset)) return 6;
        if (equals(a,seven,offset)) return 7;
        if (equals(a,eight,offset)) return 8;
        if (equals(a,nine,offset)) return 9;
        return -1; //wont
    }

    void drawHorizontalRight(char[][] matrix,int startX, int startY){
        int j = startY+1;
        int i = startX;
        while(matrix[i][j]!='*'){
            matrix[i][j]='*';
            j++;
        }
    }
    void drawHorizontalLeft(char[][] matrix,int startX, int startY){
        int j = startY-1;
        int i = startX;
        while(matrix[i][j]!='*'){
            matrix[i][j]='*';
            j--;
        }
    }
    void drawVericalDown(char[][] matrix,int startX, int startY){
        int i = startX+1;
        int j = startY;
        while(matrix[i][j]!='*'){
            matrix[i][j]='*';
            i++;
        }
    }

    void drawVericalUp(char[][] matrix,int startX, int startY){
        int i = startX-1;
        int j = startY;
        while(matrix[i][j]!='*'){
            matrix[i][j]='*';
            i--;
        }
    }

    void drawUpperRight(char[][] matrix,int startX, int startY){
        int i = startX-1;
        int j = startY+1;
        while(matrix[i][j]!='*'){
            matrix[i][j]='*';
            i--;
            j++;
        }
    }

    void drawLowerRight(char[][] matrix,int startX, int startY){
        int i = startX+1;
        int j = startY+1;
        while(matrix[i][j]!='*'){
            matrix[i][j]='*';
            i++;
            j++;
        }
    }

    void drawLowerLeft(char[][] matrix,int startX, int startY){
        int i = startX+1;
        int j = startY-1;
        while(matrix[i][j]!='*'){
            matrix[i][j]='*';
            i++;
            j--;
        }
    }

    void drawUpperLeft(char[][] matrix,int startX, int startY){
        int i = startX-1;
        int j = startY-1;
        while(matrix[i][j]!='*'){
            matrix[i][j]='*';
            i--;
            j--;
        }
    }

    char[][] timeASCIIRepresentation(char[][] dtime) {
        char[][] res ={
                {'.', '.', '.', '.', '*', '*', '*', '*', '*', '*', '*', '*', '*', '.', '.', '.', '.'},
                {'.', '.', '.', '*', '*', '.', '.', '.', '.', '.', '.', '.', '*', '*', '.', '.', '.'},
                {'.', '.', '*', '*', '.', '.', '.', '.', '.', '.', '.', '.', '.', '*', '*', '.', '.'},
                {'.', '*', '*', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '*', '*', '.'},
                {'*', '*', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '*', '*'},
                {'*', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '*'},
                {'*', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '*'},
                {'*', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '*'},
                {'*', '.', '.', '.', '.', '.', '.', '.', '*', '.', '.', '.', '.', '.', '.', '.', '*'},
                {'*', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '*'},
                {'*', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '*'},
                {'*', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '*'},
                {'*', '*', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '*', '*'},
                {'.', '*', '*', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '*', '*', '.'},
                {'.', '.', '*', '*', '.', '.', '.', '.', '.', '.', '.', '.', '.', '*', '*', '.', '.'},
                {'.', '.', '.', '*', '*', '.', '.', '.', '.', '.', '.', '.', '*', '*', '.', '.', '.'},
                {'.', '.', '.', '.', '*', '*', '*', '*', '*', '*', '*', '*', '*', '.', '.', '.', '.'}
        };

        int hh = equalsAll(dtime,1)* 10 +
                equalsAll(dtime,5);
        int mm = equalsAll(dtime,10)*10+
                equalsAll(dtime,14);

        System.out.println(hh+" "+mm);
        int x = 8, y =8;
        // stright left
        // mm == 15
        // hh == 3
        // x = 13(12/15)
        if(mm ==45) drawHorizontalLeft(res,x,y);
        if(hh == 9) drawHorizontalLeft(res,x,y);


        if(mm == 15) drawHorizontalRight(res,x,y);
        if(hh == 3) drawHorizontalRight(res,x,y);

        // mm == 45,
        // hh == 9

        // updowm
        // mm == 00
        // hh==12
        // mm == 30
        // hh == 6

        if(mm == 0) drawVericalUp(res,x,y);
        if(hh == 12) drawVericalUp(res,x,y);


        if(mm == 30) drawVericalDown(res,x,y);
        if(hh == 6) drawVericalDown(res,x,y);

        //diag upperriht
        // mm == >0  && < 15
        // hh == > 0 && < 3

        if(mm > 0 && mm < 15) drawUpperRight(res,x,y);
        if(hh > 0 && hh < 3) drawUpperRight(res,x,y);


        if(mm > 15 && mm < 30) drawLowerRight(res,x,y);
        if(hh > 3 && hh < 6) drawLowerRight(res,x,y);


        //diag lowerright
        // mm == >15  && < 30
        // hh == > 3 && < 6


        //diag lowerleft
        // mm == > 30  && < 45
        // hh == > 6 && < 9


        if(mm > 30 && mm < 45) drawLowerLeft(res,x,y);
        if(hh > 6 && hh < 9) drawLowerLeft(res,x,y);


        if(mm > 45 && mm < 60) drawUpperLeft(res,x,y);
        if(hh > 9 && hh < 12) drawUpperLeft(res,x,y);


        //diag upperleft
        // mm == > 45  && < 60
        // hh == > 9 && < 12

        return res;
    }



    /* bresnham to draw the points */
    static void bresenham(int x1, int y1, int x2,
                          int y2)
    {
        int m_new = 2 * (y2 - y1);
        int slope_error_new = m_new - (x2 - x1);

        for (int x = x1, y = y1; x <= x2; x++)
        {
            System.out.print("(" +x + "," + y + ")\n");

            // Add slope to increment angle formed
            slope_error_new += m_new;

            // Slope error reached limit, time to
            // increment y and update slope error.
            if (slope_error_new >= 0)
            {
                y++;
                slope_error_new -= 2 * (x2 - x1);
            }
        }
    }
}
