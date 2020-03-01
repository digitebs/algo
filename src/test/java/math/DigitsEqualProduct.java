package math;

/*
   medium* quiet hard due to calculation

Given an integer product, find the smallest positive (i.e. greater than 0)
 integer the product of whose digits is equal to product.
  If there is no such integer, return -1 instead.
*/
public class DigitsEqualProduct {
  int digitsProduct(int product) {
    if (product == 0) return 10;
    int res = digitsProduct(product, 0);
    return res == Integer.MAX_VALUE ? -1 : res;
  }

  int digitsProduct(int product, int ans) {

    if (product <= 9) {
      //  System.out.println(ans * 10 + product);
      return ans * 10 + product;
    }
    int min = Integer.MAX_VALUE;
    for (int i = 1; i < 10; i++) {
      // int ans = 0;
      if (product % i == 0) {
        // ans = ans * 10 + i;
        min = Math.min(digitsProduct(product / i, ans * 10 + i), min);
      }
    }
    return min;
  }

  public static void main(String[] args) {
    //
    System.out.println(new DigitsEqualProduct().digitsProduct(2));
  }
}
