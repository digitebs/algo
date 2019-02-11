package math;


/**
 *   A[0] = 23171
 *   A[1] = 21011
 *   A[2] = 21123
 *   A[3] = 21366
 *   A[4] = 21013
 *   A[5] = 21367
 *   A[5]-A[1]
 *  356
 */
public class StockMarketDay {
    static int stockmarketday(int[] price){

        int max= 0;
        int bi=0;
        for (int i = 0; i < price.length; i++) {
            if(price[bi] > price[i]) bi = i; // update the buy and sell index
            // calculate
            max = Math.max(max, price[i]- price[bi]);
        }
        return max;
    }

    public static void main(String args[]){
        System.out.println(stockmarketday(new int[]{23171,21011,21123,21366,21013,21367}));
    }
}
