package queue;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class HTreeVisual {
    public static void main(String[] a) {

        // creating object of JFrame(Window popup)
        JFrame window = new JFrame();

        // setting closing operation
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // setting size of the pop window
        window.setBounds(0, 0, 800, 600);

        // setting canvas for draw
        window.getContentPane().add(new MyCanvas());

        // set visibility
        window.setVisible(true);
    }

    public static class MyCanvas extends JComponent {
        public void paint(Graphics g) {
            // draw and display the line
            drawHTree(100, 250, 100, 1, g);
            drawHTree(300, 250, 100, 2, g);
            drawHTree(575, 250, 100, 3, g);
            //drawHTree(100, 250, 100, 3, g);
        }
    }

    /*
    public static void drawHTree(double x, double y, double length, int depth, Graphics g) {
        if (depth == 0) return;
        double x0 = x - length / 2;
        double x1 = x + length / 2;
        double y0 = y - length / 2;
        double y1 = y + length / 2;

        // draw the 3 line segments of the H-Tree
        g.drawLine((int) x0, (int) y0, (int) x0, (int) y1); // left segment
        g.drawLine((int) x1, (int) y0, (int) x1, (int) y1); // right segment
        g.drawLine((int) x0, (int) y, (int) x1, (int) y);   // connecting segment

        // at each stage, the length of segments decreases by a factor of √2
        double newLength = length / Math.sqrt(4);

        // decrement depth by 1 and draw an H-tree at each of the tips of the current ‘H’
        drawHTree(x0, y0, newLength, depth - 1, g); // lower left  H-tree
        drawHTree(x0, y1, newLength, depth - 1, g); // upper left  H-tree
        drawHTree(x1, y0, newLength, depth - 1, g); // lower right H-tree
        drawHTree(x1, y1, newLength, depth - 1, g); // upper right H-tree
    }*/

    static Queue<Double[]> queue = new LinkedList<>();
    public static void drawHTree(double x, double y, double length, int depth, Graphics g) {

        if(depth == 0) return;
        queue.offer(new Double[]{x,y});
        while(!queue.isEmpty() && depth > 0){
                for(Double[] arr: new ArrayList<>(queue)){
                    drawHTree2(arr[0],arr[1], length,g);
                    queue.poll();
                }
                length/=2; // <--
            depth--;
        }
        queue.clear();
    }

    public static void drawHTree2(double x, double y, double length, Graphics g) {
        //3lines
        double r = length/2.;
        double xl = x - r;
        double xr = x + r;


        double yu  = y -r;
        double yd = y +r;

        queue.offer(new Double[]{xl,yu}); // 1
        queue.offer(new Double[]{xl,yd}); //1
        queue.offer(new Double[]{xr,yu}); //1
        queue.offer(new Double[]{xr,yd}); //11




        g.drawLine((int) xl, (int) yu, (int) xl, (int) yd); // left segment
        g.drawLine((int) xr, (int) yu, (int) xr, (int) yd); // right segment
        g.drawLine((int) xl, (int) y, (int) xr, (int) y);   // connecting segment

    }
}
