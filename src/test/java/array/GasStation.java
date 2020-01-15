package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GasStation {


    // using sliding window techniq
    public static int canCompleteCircuit2(final List<Integer> A, final List<Integer> B) {
        List<Integer> gas = new ArrayList<>(A);
        gas.addAll(A);
        List<Integer> cost = new ArrayList<>(B);
        cost.addAll(B);


        int left = 0;
        int right = 0;
        int total = 0;

        // start with the left
        total += gas.get(left);
        total -= cost.get(left);

        while (right < gas.size()){

            // we cant reach the total;
            if(total< 0){
                total -= gas.get(left);
                total += cost.get(left);
                left++;

                if(left > right ){
                    total=0;// reset to 0;
                    right = left; // adjust the right
                    System.out.println("L: "+ left +" "+ right +" "+total);
                }
            }else{

                System.out.println("R: "+left +" "+ right + " "+total);

                if((right - left) == A.size()){
                    //System.out.println(gas.get(left) + " "+ gas.get(right));
                    return left; // found the one
                }


                total += gas.get(right);
                total -= cost.get(right);
                right++;
            }
        }


        return -1;

    }

    public static int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        List<Integer> gas = new ArrayList<>(A);
        gas.addAll(A);
        List<Integer> cost = new ArrayList<>(B);
        cost.addAll(B);

        for (int i = 0; i < A.size(); i++) {
            int mygas = 0;
            int j = i;
            for (; j < i + A.size(); j++) {
                mygas += gas.get(j);
                mygas -= cost.get(j);
                if (mygas < 0) break;
            }

            if (j == A.size() && mygas >= 0) return i; // return the path
        }
        return -1;

    }

    public static void main(String[] args) {
        List a = Arrays.asList(959, 329, 987, 951, 942, 410, 282, 376, 581, 507, 546, 299, 564, 114, 474, 163, 953, 481, 337, 395, 679, 21, 335, 846, 878, 961, 663, 413, 610, 937, 32, 831, 239, 899, 659, 718, 738, 7, 209);
        List b = Arrays.asList(982, 934, 504, 226, 710, 775, 705, 545, 647, 760, 161, 185, 95, 554, 750, 333, 773, 887, 279, 600, 9, 664, 555, 969, 203, 233, 440, 958, 399, 351, 393, 123, 367, 637, 235, 134, 664, 688, 70, 885, 326, 45, 659, 240, 827, 892, 481, 80, 208, 441, 213, 586, 970, 326, 960, 558, 563, 623, 177, 252, 598, 985, 18, 758, 496, 439, 622, 598, 97, 263, 275, 604, 861, 454, 376, 872, 873, 239, 964, 321, 187, 261, 499, 195, 4, 443, 414, 785, 809, 632, 431, 427, 271, 699, 699, 843, 33);

      //  List a = Arrays.asList(1,2);
       // List b = Arrays.asList(2,1);
        System.out.println(canCompleteCircuit2(a, b));
    }
}
