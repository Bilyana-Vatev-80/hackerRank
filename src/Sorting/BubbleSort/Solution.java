package Sorting.BubbleSort;

import java.util.Scanner;

public class Solution {
    static void countSwaps(int[] a) {
        boolean isSorted = false;
        int swap = 0;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swap++;
                    isSorted = false;
                }
            }
        }
        System.out.printf("Array is sorted in %d swaps.%n", swap);
        System.out.printf("First Element: %d%n", a[0]);
        System.out.printf("Last Element: %d", a[a.length - 1]);
    }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main (String[]args){
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int aItem = Integer.parseInt(aItems[i]);
                a[i] = aItem;
            }

            countSwaps(a);

            scanner.close();
        }
    }
