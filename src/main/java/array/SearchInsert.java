package array;

/** search, return the index to insert if not found, else return the val */
public class SearchInsert {
  /*
     logn using binary search. input is sorted
  */
  public int searchInsert(int[] nums, int target) {

    // 4 -0;
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = (right + left) / 2;
      if (nums[mid] == target) return mid;
      else if (target > nums[mid]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

  public static void main(String[] args) {
    SearchInsert si = new SearchInsert();
    System.out.println(si.searchInsert(new int[] {1, 3, 5, 6}, 7));
  }
}
