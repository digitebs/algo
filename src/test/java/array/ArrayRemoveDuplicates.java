package array;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.out;

public class ArrayRemoveDuplicates {
    public int removeDuplicates(ArrayList<Integer> a) {
        int k = 0;
        boolean seen = false;
        for (int i = 1; i < a.size(); i++) {
            if (a.get(k).equals(a.get(i))) {
                if (!seen) {
                    seen = true;
                    a.set(++k, a.get(i));
                }
            } else {
                seen = false; // reset //if they are not equal then we move our pointer to the next
                a.set(++k, a.get(i));
            }
        }
        return k + 1;
    }

    public static void main(String args[]) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1000);
        a.add(1000);
        a.add(1000);//k
        a.add(1000);//k=2
        a.add(1001);//i
        a.add(1002);//i
        a.add(1003);
        a.add(1003);
        a.add(1004);
        a.add(1005);
        out.println(new ArrayRemoveDuplicates().removeDuplicates(a));
        out.println(Arrays.toString(a.toArray()));
    }
}
