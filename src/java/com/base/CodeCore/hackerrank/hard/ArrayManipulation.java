package java.com.base.CodeCore.hackerrank.hard;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/crush/problem
public class ArrayManipulation {
    private static final Scanner scanner = new Scanner(System.in);

    static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n];
        for (int[] ar : queries) {
            int a = ar[0], b = ar[1], k = ar[2];
            arr[a - 1] += k;
            if (b < n) arr[b] -= k;
        }
        long max = -1, temp = 0;
        for (long l : arr) {
            temp += l;
            max = temp > max ? temp : max;
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

