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

    public static boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
        //  return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPower(9));
        System.out.println(isPowerOfThree(7));
        System.out.println((Math.log10(7) / Math.log10(3)));
    }
}
