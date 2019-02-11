package recursion;

import org.junit.Test;

/**
 * Created by johnlim on 1/4/17.
 */
public class LinkedinRecursion {

    public int pow(int n, int m){

        if(m==1)
            return n;

        return n* pow(n,m-1);
    }

    @Test
    public void pow(){
        System.out.print(pow(2,3));
    }
    /**
     *
     *
     *
     * @param num
     */

    public void decimalTobinary(int num){

        if(num > 0) {
            decimalTobinary(num / 2);
            System.out.print(num % 2);
        }
    }
    @Test
    public void decimalTobinary(){

        decimalTobinary(2);
    }
}
