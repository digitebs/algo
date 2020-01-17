package math;

/**
 * find if a number is power of i,j
 */
public class Power {
    static boolean isPower(int a) {
        if(a==1) return true;
        for (int i = 2; i < a; i++) {
            int j =2;
            double pow;
            do{
                pow =Math.pow(i,j);
                if(pow==a) return true;
                j++;
            }while (pow <a);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPower(9));
    }
}
