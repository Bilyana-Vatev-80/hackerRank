package DictionariesAndHashmaps.HashTableRansomNote;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String,Integer> maps = new HashMap<>();
        boolean yes = true;
        Arrays.stream(magazine).forEach(s -> maps.put(s, !maps.containsKey(s) ? 1 :maps.get(s) + 1));
        for (String s : note) {
            if(maps.containsKey(s) && maps.get(s) > 0){
                maps.put(s, maps.get(s) -1);
            } else {
                yes = false;
                break;
            }
        }
        System.out.println(yes ? "Yes" : "No");

    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
