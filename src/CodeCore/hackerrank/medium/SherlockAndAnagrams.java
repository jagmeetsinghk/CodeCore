package CodeCore.hackerrank.medium;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
public class SherlockAndAnagrams {


    private static final Scanner scanner = new Scanner(System.in);

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int len = s.length();
        ArrayList<String> combinations = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = j; k <= i; k++)
                    sb.append(s.charAt(k));
                combinations.add(sb.toString());
            }
        }

        Map<String, Integer> note = new Hashtable<>();
        combinations.stream().map(a -> {
            char[] arr = a.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }).forEach(x -> {
            note.computeIfPresent(x, (k, v) -> v + 1);
            note.putIfAbsent(x, 1);
        });
        return note.values().stream().mapToInt(n -> n * (n - 1) / 2).sum();
    }

    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

