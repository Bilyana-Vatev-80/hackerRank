package Java.Anagrams;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    static boolean isAnagram(String a, String b) {
        if(a.length() != b.length()){
            return false;
        }
        a = a.toLowerCase();
        b = b.toLowerCase();

        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            char letter = b.charAt(i);
            if(!map.containsKey(letter)){
                map.put(letter, 1);
            } else {
                map.put(letter, map.get(letter) +1);
            }
        }
        for (int i = 0; i < a.length(); i++) {
            char letter = a.charAt(i);
            if(!map.containsKey(letter) || map.get(letter) == 0){
                return false;
            }
            map.put(letter, map.get(letter) - 1);
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
