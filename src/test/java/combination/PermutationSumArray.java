package combination;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/** given an array of movie len, return all possible movie that can fit in the flight len */
public class PermutationSumArray {
  List<List<Integer>> res = new ArrayList<>();

  void permutationSum(int[] candidates, int j, int target, List<Integer> curr) {

    if (target == 0) {
      res.add(new ArrayList<>(curr));
      return;
    }

    if (j == candidates.length) return;
    curr.add(candidates[j]);
    permutationSum(candidates, j + 1, target - candidates[j], curr);
    curr.remove(curr.size() - 1);
    permutationSum(candidates, j + 1, target, curr);
  }

  List<List<Integer>> permutationSum(int[] candidates, int target) {
    permutationSum(candidates, 0, target, new ArrayList<>());
    return res;
  }

  public static void main(String[] args) {
    //  out.println(new CombinationSumArray().combinationSum(new int[]{7,8,10,6,8},28));
    out.println(new PermutationSumArray().permutationSum(new int[] {2, 3,4,5,6}, 9));
  }
}
