package math;

import com.sun.tools.javac.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static java.lang.System.out;

public class PlusOne {
    static ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        for(int i = a.size()-1; i >= 0 ; i--){
            if(a.get(i) == 9){ // okay we will exceed 10
                a.set(i,0);
                if(i == 0 ) a.add(0,1);
            }else{
                a.set(i,a.get(i)+1);
                break; // stop
            }
        }

        Iterator<Integer> it = a.iterator();
        while(it.hasNext()){
            if(it.next() == 0)it.remove();
            else break;
        }
        return a;
    }

    public static void main(String[] args) {
        out.println(plusOne(new ArrayList<>(Arrays.asList(1,2))));
    }
}
