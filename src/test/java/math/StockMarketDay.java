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
    /**
     * draw a graph is easier
     *
     * maximize profit find the best buy and sell.
     * linear solution. using buy at min price and finding peak
     */
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

    /**
     * allow multiple transaction
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;
        int min = prices[0];
        int res = 0;
        for(int i =0; i < prices.length-1; i++){
            if(prices[i] > prices[i+1]){
                res += prices[i] - min;
                min = prices[i+1];
            }
        }
        res += prices[n-1]- min;
        return res;
    }

    public static void main(String args[]){
        System.out.println(stockmarketday(new int[]{7,1,5,3,6,4}));
    }
}
