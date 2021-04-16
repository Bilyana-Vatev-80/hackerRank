package Array.NewYearChaos;

import java.util.Scanner;

public class NewYearChaos {
    static void minimumBribes(int[] arr) {
        int swapCount = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != (i + 1)) {
                if ((i -1) >= 0 && arr[i - 1] == i + 1) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapCount++;
                } else if((i -2) >= 0 && arr[i - 2] == i + 1){
                    arr[i - 2] = arr[i -1];
                    arr[i - 1] = arr[i];
                    arr[i] = arr[i -2];
                    swapCount += 2;
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(swapCount);
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();

    }
}
