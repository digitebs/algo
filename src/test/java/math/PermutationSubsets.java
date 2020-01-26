package math;

import java.util.*;
import java.util.stream.Collectors;

public class PermutationSubsets {


    static List<List<Integer>> res1 = new ArrayList<>();
    public void subsets(LinkedList<Integer> temp, LinkedList<Integer> nums) {
        LinkedList<Integer> r = new LinkedList<>(nums);
        for(int i =0; i < nums.size(); i++){
            LinkedList<Integer> a = new LinkedList<>(temp); // initially empty
            a.add(nums.get(i));
            res1.add(a);
            r.remove(0);
            subsets(a,r); //remove index zero
        }
    }

    /*
        Given a set of distinct integers, nums, return all possible subsets (the power set).

        Note: The solution set must not contain duplicate subsets.
     */
    public List<List<Integer>> subsets(int[] nums) {
        res1.add(new LinkedList<>());
        subsets(new LinkedList<>(), Arrays.stream(nums).boxed().collect(Collectors.toCollection(LinkedList::new)));
        return res1;
    }

    public static void main(String[] args) {
        //  ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        //  new LargestPermutation().largestPermutation(res, new ArrayList<>(Arrays.asList(1,2,3,4)),0);
        // System.out.println(res);
        new PermutationSubsets().subsets(new int[]{1,2,3});
        System.out.println(res1);
    }
}
