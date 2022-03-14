package math;

public class ArithmeticSlices {
  public int numberOfArithmeticSlices(int[] nums) {
    int count=0;

    if(nums.length < 3) return 0;

    int n=-1;
    for(int i=1; i < nums.length-1; i++){

      int a = nums[i] - nums[i-1];
      int b = nums[i+1] - nums[i];

      if(a==b){
        count++;
        n++;
      }else{
        count+= n*(1+n)/2;
        n=-1;
      }
    }

    return count + n*(1+n)/2;
  }

  public static void main(String[] args) {
    ArithmeticSlices as = new ArithmeticSlices();
    System.out.println(as.numberOfArithmeticSlices(new int[]{1,2,3,4}));
  }
}
