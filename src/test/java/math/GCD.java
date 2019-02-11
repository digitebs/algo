package math;

public class GCD {


    // 10, 15
    // 10, 10
    // 0, 10
    // 0 , 5

    // mod allows your tp flip who is greater in denominator
    static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        System.out.println(gcd(10,15));
    }
}
