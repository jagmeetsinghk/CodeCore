package CodeCore.hackerrank.easy;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/ctci-ransom-note/problem
public class HashTableRansomNote {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Hashtable<String, Integer> magzineHash = new Hashtable<>();
        Arrays.stream(magazine).forEach(s -> {
            if (magzineHash.containsKey(s)) magzineHash.put(s, magzineHash.get(s) + 1);
            else magzineHash.put(s, 1);
        });
        for (String s : note) {
            int sCount = magzineHash.getOrDefault(s, 0);
            if (sCount == 0) {
                System.out.println("No");
                return;
            } else magzineHash.put(s, sCount - 1);
        }
        System.out.println("Yes");
    }

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
