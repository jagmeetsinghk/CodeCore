package java.com.base.CodeCore.hackerrank.easy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/two-strings/problem
public class TwoStrings {
    private static final Scanner scanner = new Scanner(System.in);

    static String twoStrings(String s1, String s2) {
        HashSet<Character> s1Chars = new HashSet<>(s1.length());
        HashSet<Character> s2Chars = new HashSet<>(s2.length());
        for (Character c : s1.toCharArray()) s1Chars.add(c);
        for (Character c : s2.toCharArray()) s2Chars.add(c);

        for (Character c : s1Chars) if (s2Chars.contains(c)) return "YES";

        return "NO";
    }

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
