package tree;

import java.util.*;

public class Panagrams {

    // 48 , 24
    private static String charSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static TreeSet<Integer> primes = new TreeSet<>();
    private static boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) if (number % i == 0) return false;
        return true;
    }

    private static String pan(int[] arr, int n) {

        TreeSet<Integer> sortedPrimes = new TreeSet<>();
        LinkedList<Integer> temp = new LinkedList<>();

        for (int p : primes) {
            if (arr[0] > p && arr[0] %p == 0 && primes.contains(arr[0]/p)) { // makes sure complement is in
                sortedPrimes = new TreeSet<>();
                temp = new LinkedList<>();

                temp.add(arr[0]/p);
                temp.add(p);

                sortedPrimes.add(temp.getFirst());
                sortedPrimes.add(temp.getLast());

                int i;
                for (i = 1; i < arr.length; i++) {
                    if((arr[i] % temp.get(temp.size() - 1) != 0)) break; // dont atemp till last
                    else {
                        temp.add(arr[i] / temp.getLast());// get the last
                        sortedPrimes.add(temp.getLast());
                    }
                }
                if( i == arr.length) break; // found it
            }
        }



        StringBuilder sb = new StringBuilder();
        for (int i : temp) {
            sb.append(charSet.charAt(sortedPrimes.headSet(i).size()));
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        for (int i = 10000; i >= 2; i--) {
            if (isPrime(i)) primes.add(i);
        }

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = scan.nextInt();
            int l = scan.nextInt();

            int arr[] = new int[l];
            for (int j = 0; j < l; j++) {
                arr[j] = scan.nextInt();
            }
            // long start = System.currentTimeMillis();

            try {
                String res = pan(arr, n);
                System.out.println("Case #" + i + ": " + res);
            }catch (Exception e){
                e.printStackTrace();
            }

        }


        // System.out.println(System.currentTimeMillis() - start);
        // hmm brute force?
    }
}
