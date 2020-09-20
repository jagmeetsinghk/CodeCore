package CodeCore.hackerrank.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.hackerrank.com/challenges/recursive-digit-sum/problem
public class RecursiveDigitSum {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().trim().split("[ ]+");
        String n = input[0];
        int k = Integer.parseInt(input[1]);
        long start, end;
        start = System.currentTimeMillis();
        int superDigit1 = superDigit1(n, k);
        end = System.currentTimeMillis();
        System.out.println(end - start + ": " + superDigit1);
        start = System.currentTimeMillis();
        int superDigit2 = superDigit2(n, k);
        end = System.currentTimeMillis();
        System.out.println(end - start + ": " + superDigit2);
    }

    private static int superDigit1(String n, int k) {
        if (n.length() == 1) return Integer.parseInt(n);
        int rem = (int) (((n.chars().mapToLong(Character::getNumericValue).sum()) % 9) * k % 9);
        return rem == 0 ? 9 : rem;
    }

    private static int superDigit2(String n, int k) {
        if (n.length() == 1) return Integer.parseInt(n);
        int rem = (int) ((n.chars().mapToLong(Character::getNumericValue).sum() * k) % 9);
        return rem == 0 ? 9 : rem;
    }
}
