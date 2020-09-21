package CodeCore.hackerrank.easy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
public class MakingAnagrams {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int[] ar1 = a.chars().sorted().toArray();
        int[] ar2 = b.chars().sorted().toArray();
        Integer aLen = ar1.length, bLen = ar2.length;
        int ai = 0, bi = 0, count = 0;
        while (ai < aLen && bi < bLen) {
            if (ar1[ai] > ar2[bi]) {
                bi++;
                count++;
            } else if (ar1[ai] < ar2[bi]) {
                ai++;
                count++;
            } else {
                ai++;
                bi++;
            }
        }
        count += aLen - ai;
        count += bLen - bi;
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
