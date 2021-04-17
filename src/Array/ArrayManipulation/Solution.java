package Array.ArrayManipulation;

import java.util.Scanner;

public class Solution {
    static long arrayManipulation(int n, int[][] queries) {
       long[] result = new long[n];
       int length = queries.length;
       long max = Long.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            int start = queries[i][0] - 1;
            int end = queries[i][1] -1;
            int add = queries[i][2];
            result[start] += add;

            if(end + 1 < n){
                result[end + 1] -= add;
            }
        }
        for (int i = 1; i < n; i++) {
            result[i] += result[i - 1];
            max = Math.max(max, result[i]);
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){


        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        scanner.close();
        long result = arrayManipulation(n, queries);
        System.out.println(result);

    }
}
