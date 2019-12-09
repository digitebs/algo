package sort;

public class FindPeakElement {
    /**
     *
     * peak element log n solution where pivot is bigger than left && right
     * @param nums
     * @param lo
     * @param hi
     * @return
     */
    public int findPeakElement(int[] nums, int lo, int hi) {

        while (lo <= hi) {
            int pivot = ((hi + lo)) / 2;
            if ((pivot == 0 || nums[pivot - 1] < nums[pivot]) &&
                    (pivot == hi || nums[pivot] > nums[pivot + 1])) return pivot;
            if (nums[pivot] < nums[pivot + 1]) lo = pivot + 1;
            else hi = pivot - 1;
            // System.out.print(pivot+ " "+lo + " "+hi);
        }

        return 0;
    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        return findPeakElement(nums, 0, nums.length - 1);

    }

    public static void main(String[] args) {
        FindPeakElement fpe = new FindPeakElement();
        int[] nums = {42,-14,-5,7,8,40,8, 3};
        System.out.println(nums[fpe.findPeakElement(nums)]);
    }
}
