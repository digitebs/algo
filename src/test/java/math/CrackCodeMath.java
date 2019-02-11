package math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * Created by johnlim on 23/1/17.
 */
public class CrackCodeMath {

    @Test
    public void isPower() {
        System.out.println(isPower(1));
    }
    public boolean isPower(int a) {
        if(a==1)
            return true;
        for (int i = 2; i < a; i++) {
            int j =2;
            double pow;
           do{
               pow =Math.pow(i,j);
               if(pow==a){
                   return true;
               }
               j++;
            }while (pow <a);

        }
        return false;
    }

    private boolean isPrime(int n){

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    @Test
    public void primesum() {
    //    System.out.println(primesum(16777214));
        System.out.println(primesum(4));
        System.out.println(primesum(8));
        System.out.println(primesum(12));
    }


    public ArrayList<Integer> primesum(int a) {
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
}
