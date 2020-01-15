package array;

import java.util.ArrayList;
import java.util.Collections;


/**
 * return all combination of array from i to n, where k is the number of combination
 *
 */
public class CombinationArray {
    public void combine(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> arr, int i, int n, int k)   {
        if(arr.size() == k) res.add(arr);
        else{
            for(int j=i; j<= n; j++) {
                ArrayList<Integer> a = new ArrayList<>(arr);
                a.add(j);
                combine(res,a,j+1,n,k);
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        new CombinationArray().combine(res, arr,2,4,3);

        /*Collections.sort(res, (o1, o2) -> {
            for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
                int c = o1.get(i).compareTo(o2.get(i));
                if (c != 0) {
                    return c;
                }
            }
            return Integer.compare(o1.size(), o2.size());
        });*/
        System.out.println(res);
    }
}
