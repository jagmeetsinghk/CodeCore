package CodeCore.hackerrank.hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.hackerrank.com/challenges/ctci-merge-sort/problem
public class CountingInversions {

    private static long countInversions(int[] arr, int[] temp, int from, int to) {
        if (from >= to) {
            return 0;
        }
        int mid = (from + to) >>> 1;
        long count = 0L;
        count += countInversions(arr, temp, from, mid);
        count += countInversions(arr, temp, mid + 1, to);
        count += merge(arr, temp, from, mid, to);
        return count;
    }

    private static long merge(int[] arr, int[] temp, int from, int mid, int to) {
        System.arraycopy(arr, from, temp, from, to - from + 1);
        long count = 0L;
        int i = from, j = mid + 1;
        for (int k = from; k <= to; k++) {
            if (i > mid) {
                arr[k] = temp[j++];
            } else if (j > to) {
                arr[k] = temp[i++];
            } else if (temp[j] < temp[i]) {
                arr[k] = temp[j++];
                count += mid - i + 1;
            } else {
                arr[k] = temp[i++];
            }
        }
        return count;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            System.out.println(countInversions(arr, new int[n], 0, n - 1));
        }
    }
}
