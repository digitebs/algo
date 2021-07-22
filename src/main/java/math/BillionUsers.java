package math;


/**

 given an array of growth. the number of users using an app is g^t.
 Return the number of full days it will take before we have a total of 1 billion users across
 all N apps.


 Example 1
 growthRates = [1.5]
 output = 52
 Example 2
 growthRates = [1.1, 1.2, 1.3]
 output = 79
 Example 3
 growthRates = [1.01, 1.02]
 output = 1047
 */
public class BillionUsers {

  // 38730 fix days?
// 207232669 // max possible n

  int bin(float[] g, float s, float e){

    int mid = (int)((s+e)/2f);
    double ns= calc(g,mid-1);
    double ne= calc(g,mid);
    if( ns <= 1e9 && ne >= 1e9){
      return mid;
    }
    else if(ne > 1e9){
      return bin(g,s,mid-1);
    }else {
      return bin(g,mid+1,e);
    }
  }

  double calc(float[] g,int n){
    double s=0;
    for(float a: g){
      s+=Math.pow(a,n);
    }
    return s;
  }
  int getBillionUsersDay(float[] growthRates) {
    // Write your code here

    return bin(growthRates,0f,2050);
    /*double y = 1e9;

    System.out.println(Float.MIN_NORMAL);
      double n = Math.log10(y)/Math.log10(1.01);
      return  (int)Math.ceil(n);*/
  }



  public static void main(String[] args) {
    BillionUsers bu = new BillionUsers();
    System.out.println(
     bu.getBillionUsersDay(new float[]{1.5f}));
    System.out.println(
    bu.getBillionUsersDay(new float[]{1.1f,1.2f,1.3f}));
    System.out.println(
        bu.getBillionUsersDay(new float[]{1.01f,1.02f}));
    System.out.println(bu.calc(new float[]{1.5f},50));
/*
    System.out.println(bu.calc(new float[]{1.01f,1.02f},1066));
    System.out.println(bu.calc(new float[]{1.1f,1.2f,1.3f},79));
  */
  }

}
