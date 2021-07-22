package search;

import java.util.Arrays;

/*

  given revenue and milestone array return the days it reaches the milestone.

  revenues = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
  milestones = [100, 200, 500]
  output = [4, 6, 10]

  medium*
 */
public class RevenueMilestone {
  int bin(int[] arr, int x){

    int n = arr.length;
    int l = 0;
    int r = n;

    while(l  < r){
      int mid = (r+l)/2;
     //  System.out.println(x+": "+ mid+" "+ r+" "+l);
      if(arr[mid] == x || mid > 0 && x > arr[mid-1] && x < arr[mid])
      {
        return mid+1;
      }else if(arr[mid] > x){
        r = mid;
      }else{
        l = mid + 1;
      }
    }

    return -1;

  }

  int[] getMilestoneDays(int[] revenues, int[] milestones) {
    // Write your code here;

    /*
        int revenues_1[] = {100, 200, 300, 400, 500};
    int milestones_1[] = {300, 800, 1000, 1400};

    int revenues_2[] = {700, 800, 600, 400, 600, 700};
    int milestones_2[] = {3100, 2200, 800, 2100, 1000};
    */
    int n = revenues.length;
    int m = milestones.length;
    int[] run = new int[n];

    for(int i =0; i < n; i++){
      run[i] = (i==0?0:run[i-1]) + revenues[i];
    }

    int[] res = new int[m];
    for(int i=0; i < m ; i++){
      res[i] = bin(run,milestones[i] );
    }

    return res;
  }

  public static void main(String[] args) {
    //

    RevenueMilestone rm = new RevenueMilestone();
    int[] r1 = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    int[] r2 = new int[]{100, 200, 300, 400, 500};
    int[] r3 = new int[]{700, 800, 600, 400, 600, 700};
    int[] r4 = new int[]{100,200};

    int[] m1 = new int[]{100,200,500};
    int[] m2 = new int[]{300, 800, 1000, 1400};
    int[] m3 = new int[]{3100, 2200, 800, 2100, 1000};
    int[] m4 = new int[]{150, 350,100,50};

    int[] res1 = rm.getMilestoneDays(r1,m1);
    int[] res2 = rm.getMilestoneDays(r2,m2);
    int[] res3 = rm.getMilestoneDays(r3,m3);
    int[] res4 = rm.getMilestoneDays(r4,m4);

    System.out.println(Arrays.toString(res1));
    System.out.println(Arrays.toString(res2));
    System.out.println(Arrays.toString(res3));
    System.out.println(Arrays.toString(res4));
  }
}
