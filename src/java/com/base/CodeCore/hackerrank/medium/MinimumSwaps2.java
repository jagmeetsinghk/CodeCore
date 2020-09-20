package java.com.base.CodeCore.hackerrank.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.hackerrank.com/challenges/minimum-swaps-2/problem
public class MinimumSwaps2 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] ar = Arrays.stream(br.readLine().trim().split("[ ]+")).mapToInt(Integer::parseInt).toArray();
        int[] ar_sorted = Arrays.stream(ar).sorted().toArray();
        int expected, index, temp, swaps = 0;
        for (int i = 0; i < ar.length; i++) {
            expected = ar_sorted[i];
            if (ar[i] == expected) continue;

            index = linearSearch(ar, expected, i);
            temp = ar[index];
            ar[index] = ar[i];
            ar[i] = temp;

            swaps++;
        }
        System.out.println(swaps);
    }

    private static int linearSearch(int[] ar, int expected, int start) {
        for (int i = start; i < ar.length; i++)
            if (ar[i] == expected)
                return i;
        return -1;
    }

}
