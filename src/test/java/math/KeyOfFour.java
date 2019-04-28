package math;

import java.util.Scanner;

public class KeyOfFour {

    // 48 , 24
    private static int[] pair(int n) {
        int a = n % 10 == 5 ? 2 : 1;
        int r = (n - a) / 10;
        int f = 1;
        do {
            int m = r % 10;
            a += (f *= 10) * (m == 4 ? 2 : m);
        } while ((r /= 10) != 0);
        return new int[]{a, n - a};
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 1; i <= t; ++i) {
            int m = scan.nextInt();
            long start = System.currentTimeMillis();
            int[] res = pair(m);
            System.out.println("Case #" + i + ": " + res[0] + " " + res[1]);
            System.out.println(System.currentTimeMillis() - start);
            // hmm brute force?
        }
    }
}
