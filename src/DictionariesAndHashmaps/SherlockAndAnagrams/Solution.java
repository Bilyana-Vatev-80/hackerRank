package DictionariesAndHashmaps.SherlockAndAnagrams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    static int sherlockAndAnagrams(String s) {
        Map<String,Integer> subs = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char[] chars = s.substring(i, j + 1).toCharArray();
                Arrays.sort(chars);
                String k = new String(chars);

                if(subs.containsKey(k)){
                    subs.put(k, subs.get(k) + 1);
                } else {
                    subs.put(k, 1);
                }
            }
        }
        int countAnagrams = 0;
        for (String s1 : subs.keySet()) {
            int v = subs.get(s1);
            countAnagrams += (v * (v - 1))/2;
        }
       return countAnagrams;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result;
            result = sherlockAndAnagrams(s);
            System.out.println(result);
        }
        scanner.close();
    }
}
