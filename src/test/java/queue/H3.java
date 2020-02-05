package queue;

/** |-| */
/*
public class H3 {

    package main.java.pramp;



    public static void drawLine(double x1, double y1, double x2, double y2) {
        System.out.println("Line is drawn by the point: " + "(" + x1 + "," + y1 + ") " + "and " + "(" + x2 + "," + y2 + ")");
    }


    static Queue<Double[]> queue = new LinkedList<>();


    // 4 + 4 + 4 + 4  == dpeth
    // 4 +
    //  8 +
    // 16 +
    // 32

    // 4x O(depeth)* 4

    //2^depth

    // bfs
    public static void drawHTree(double x, double y, double length, int depth) {

        if(depth == 0) return;
        while(!queue.isEmpty()){
            if(depth > 1){
                for(Double[] arr: new ArrayList<>(queue)){
                    Double[] c = queue.poll();
                    drawHTree2(c[0],c[1], length);
                }
                length/=2; // <--
            }
            depth--;
        }
    }

    public static void drawHTree2(double x, double y, double length) {
        //3lines

        double r = length/2.;
        double xl = x - r;
        double xr = x + r;


        double yu  = y -r;
        int yd = y +r;

        list.offer(new Double[]{xl,yu}); // 1
        list.offer(new Double[]{xl,yd}); //1
        list.offer(new Double[]{xr,yu}); //1
        list.offer(new Double[]{xr,yd}); //11


        drawLine(xl,yu,xl,yd); //vertical
        drawLine(xr,yu,xr,yd); //vertical
        drawLine(x1,y,xr,y); // y deosnt

        (xl,yu)<4
               (xl,yu)<4
                     (xl,yu)<4

                     (xl,yd)< 4

                     (xr, yu)< 4

                     (xr, yd); <4

              (xl,yd)< 4

              (xr, yu)< 4

              (xr, yd); <4
        (xl,yd)< 4

        (xr, yu)< 4

        (xr, yd); <4


        // 4 coordeinates //recursively call drawtree

    }

    public static void drawHTree(double x, double y, double length, int depth) {
        if (depth == 0) return;

        double x0 = x - length / 2;
        double x1 = x + length / 2;
        double y0 = y - length / 2;
        double y1 = y + length / 2;

        // draw the 3 line segments of the H-Tree
        drawLine(x0, y0, x0, y1); // left segment
        drawLine(x1, y0, x1, y1); // right segment
        drawLine(x0, y, x1, y);   // connecting segment

        // at each stage, the length of segments decreases by a factor of √4
        double newLength = length / Math.sqrt(4);

        // decrement depth by 1 and draw an H-tree at each of the tips of the current ‘H’
        drawHTree(x0, y0, newLength, depth - 1); // lower left  H-tree
        drawHTree(x0, y1, newLength, depth - 1); // upper left  H-tree
        drawHTree(x1, y0, newLength, depth - 1); // lower right H-tree
        drawHTree(x1, y1, newLength, depth - 1); // upper right H-tree
    }


}*/
