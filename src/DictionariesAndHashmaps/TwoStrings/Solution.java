package DictionariesAndHashmaps.TwoStrings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    static String twoStrings(String s1, String s2) {
        Set<Character> s1_char = new HashSet<>();
        Set<Character> s2_char = new HashSet<>();

        for (int i = 0; i < s1.length(); i++) {
            s1_char.add(s1.charAt(i));
        }

        for (int i = 0; i < s2.length(); i++) {
            s2_char.add(s2.charAt(i));
        }

        s1_char.retainAll(s2_char);
        if(!s1_char.isEmpty()){
            return "YES";
        } else {
            return "NO";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
