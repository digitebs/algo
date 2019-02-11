package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class CombinationSumArray {
    public void combinationSum(ArrayList<Integer> candidates, int j, int target, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> res) {
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = j; i < candidates.size(); i++){
            if(target < candidates.get(i))
                return;
            curr.add(candidates.get(i)); // forward
            combinationSum(candidates,i,target - candidates.get(i),curr,res);
            curr.remove(curr.size()-1); // backtrack
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Collections.sort(a);
        a = a.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
        combinationSum(a,0,target,new ArrayList<>(),res);
        return res;
    }

    public static void main(String[] args) {
        out.println(new CombinationSumArray().combinationSum(new ArrayList<>(Arrays.asList(7,8,10,6,8)),28));
    }
}
