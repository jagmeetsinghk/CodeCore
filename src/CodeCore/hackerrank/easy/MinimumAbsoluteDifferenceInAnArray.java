package CodeCore.hackerrank.easy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
public class MinimumAbsoluteDifferenceInAnArray {

    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {
        int min = Integer.MAX_VALUE, len = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < len - 1; i++) {
            int absoluteDiff = Math.abs(arr[i] - arr[i + 1]);
            min = Math.min(absoluteDiff, min);
        }
        return min;
    }

//     O(n2)
//
//     static int minimumAbsoluteDifference(int[] arr) {
//        int min = Integer.MAX_VALUE, len = arr.length;
//        for(int i = 0; i < len-1; i++){
//            for(int j = i + 1; j < len; j++){
//                int absoluteDiff = Math.abs(arr[i] - arr[j]);
//                min = Math.min(min, absoluteDiff);
//            }
//        }
//        return min;
//    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = minimumAbsoluteDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}