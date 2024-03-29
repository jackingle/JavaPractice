
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
	static void checkMagazine(String[] magazine, String[] note) {

        HashMap<String, Integer> usableWords = makeMap(magazine);
        for (int i = 0; i < note.length; i++) {
            if (usableWords.containsKey(note[i]) && usableWords.get(note[i]) > 0) {
                usableWords.merge(note[i], 1, Integer::sum); 
            } else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }


    private static HashMap<String, Integer> makeMap(String[] words) {
        HashMap<String, Integer> map = new HashMap();

        for (int i = 0; i < words.length; i++) {
            map.merge(words[i], 1, Integer::sum);
        }
        return map;
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
