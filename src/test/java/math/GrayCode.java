package math;

import java.util.ArrayList;

import static java.lang.System.out;

public class GrayCode {
    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        for (int i = 0; i < a; i++) {
            for (int j = arr.size() - 1, pad = 1 << i; j >= 0; j--) {
                arr.add(pad + arr.get(j));
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        out.println(new GrayCode().grayCode(2));
    }
}
