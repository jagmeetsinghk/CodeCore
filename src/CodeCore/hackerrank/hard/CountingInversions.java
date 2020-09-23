package CodeCore.hackerrank.hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/ctci-merge-sort/problem
public class CountingInversions {

    private static long mergeSortCount(int[] a, int[] aux, int from, int to) {
        if (from >= to) {
            return 0;
        }
        int mid = (from + to) >>> 1;
        long count = 0L;
        count += mergeSortCount(a, aux, from, mid);
        count += mergeSortCount(a, aux, mid + 1, to);
        count += merge(a, aux, from, mid, to);
        return count;
    }

    private static long merge(int[] a, int[] aux, int from, int mid, int to) {
        System.arraycopy(a, from, aux, from, to - from + 1);
        long count = 0L;
        int i = from, j = mid + 1;
        for (int k = from; k <= to; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > to) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
                count += mid - i + 1;
            } else {
                a[k] = aux[i++];
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            System.out.println(mergeSortCount(arr, new int[n], 0, n - 1));
        }
    }
}
