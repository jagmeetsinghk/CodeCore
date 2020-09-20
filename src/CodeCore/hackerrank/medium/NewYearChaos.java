package CodeCore.hackerrank.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.hackerrank.com/challenges/new-year-chaos/problem
public class NewYearChaos {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] ar = Arrays.stream(br.readLine().trim().split("[ ]+")).mapToInt(Integer::parseInt).toArray();
            minimumBribes(ar);
        }
    }

    static void minimumBribes(int[] ar) {
        int[] ar_sorted = Arrays.stream(ar).sorted().toArray();
        int expected, index, temp, bribes = 0;
        for (int i = 0; i < ar.length; i++) {
            expected = ar_sorted[i];
            if (ar[i] == expected) continue;

            index = linearSearch(ar, expected, i);
            temp = ar[index];
            ar[index] = ar[i];
            ar[i] = temp;

            bribes++;
        }
        System.out.println(bribes);
    }

    private static int linearSearch(int[] ar, int expected, int start) {
        for (int i = start; i < ar.length; i++)
            if (ar[i] == expected)
                return i;
        return -1;
    }
}
