package search;

import java.text.DecimalFormat;

public class RootNumber {
    /*
        root of a number
     */
    static double root(double x, int n) {
        final double E = 0.001; // precision
        double right = x;
        double left = 0;
        while(left<right){
            double mid = (right + left)/2;
            double num = Math.pow(mid,n);
            if(Math.abs(num - x) <= E){
                return Double.parseDouble(new DecimalFormat("#.###").format(mid).toString());
            }else if(x < num){
                right = mid;
            }else{
                left = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // y ^ 3 = 7;
        // logy 7 = 3
        System.out.println(root(7,3));
    }
}
