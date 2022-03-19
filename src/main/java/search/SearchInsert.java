package search;

public class SearchInsert {
  public int searchInsert(int[] nums, int target) {
    var hi = nums.length -1;
    var lo = 0;

    var mid = lo +(hi-lo)/2;
    while(lo <= hi){
      if(nums[mid] < target){
        lo = mid +1;
      }else{
        hi = mid -1;
      }
      mid = lo +(hi-lo)/2;
    }

    return lo;
  }
}
