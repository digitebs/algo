package math;

import java.util.ArrayList;
import java.util.Hashtable;

public class Prime {

    /**
     * find the  pair prime that sum to a
     * @param a
     * @return
     */
    static ArrayList<Integer> primesum(int a) {
        ArrayList<Integer> res = new ArrayList<>();
        Hashtable<Integer,Integer> primes = new Hashtable();
        int max=1;
        for (int i = 2; i <= a/2; i++) {
            if(isPrime(i)) {
                max=Math.max(max,i);
                primes.put(i, i);
            }
        }

        // System.out.println(primes);
        for (int i = 2; i <= max; i++) {
            if(primes.get(i)==null)
                continue;
            int c =a - primes.get(i);
            if(isPrime(c) ){
                res.add(primes.get(i));
                res.add(c);
                return res;
            }

        }
        return res;
    }

    static boolean isPrime(int n){
        int sqrt = (int)Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if(n%i==0) return false;
        }
        return true;
    }

    /*
        count all primes less than n
     */
     static  int countPrimes(int n) {
        boolean[] f = new boolean[n];
        int count = n;
        int sqrt = (int)Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if(!f[i])
                for(int j = i * i;j < n ;j+=i){
                    if(!f[j]){
                        f[j] = true;
                        count--;
                    }
                }
        }
        return count > 2 ? count-2 : 0;
    }

    public static void main(String[] args) {
        countPrimes(5);
        System.out.println(primesum(4));
        System.out.println(primesum(8));
        System.out.println(primesum(12));

    }
}
