package math;

import java.util.*;

public class LargestPermutation {

    // 1 2 3 4, 1, 1
    // 1 2 3 4, 1 ,2
    // 2 1 3 4, 2, 1
    // 1 2 3 4 , 2
    /*
        largest possible permutation
     */
    public void largestPermutation(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> arr, int i)   {
            for(int j=i; j< arr.size(); j++) {
                Collections.swap(arr, j, i);
                largestPermutation(res, arr, i + 1);
                Collections.swap(arr, i, j); //backtracking
            }
            if(i == arr.size()-1){
                res.add(new ArrayList<>(arr));
            }
    }
    public static void main(String[] args) {
         ArrayList<ArrayList<Integer>> res = new ArrayList<>();
          new LargestPermutation().largestPermutation(res, new ArrayList<>(Arrays.asList(1,2,3,4)),0);
         System.out.println(res);
    }
}
