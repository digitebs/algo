package array;

import java.util.Arrays;

public class PushZeroEnd {

    // damn 2 loops one is to check its zero
    static void push(int[] num) {
        for (int i = 0; i < num.length; i++) {
            if(num[i] == 0)
            for (int j = i; j < num.length - 1; j++) {
                num[j] = num[j + 1];
                num[j + 1] = 0;
            }
        }

    }

    // linear, just override then increase position
    static void push2(int[] num) {
        int pos=0;
        for (int i = 0; i < num.length; i++) {
            if(num[i] != 0) num[pos++] = num[i];
        }

        for (int i =  num.length-1; i > pos; i--)
                num[i]=0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 0, 3};
        push2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
