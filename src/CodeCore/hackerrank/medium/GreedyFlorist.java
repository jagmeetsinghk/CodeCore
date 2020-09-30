package CodeCore.hackerrank.medium;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/greedy-florist/problem
public class GreedyFlorist {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, Integer[] c) {
        int numOfFlowers = c.length, cost = 0;
        if (k >= numOfFlowers) {
            for (int i = 0; i < k; i++) {
                cost += c[i];
            }
            return cost;
        }
        Arrays.sort(c, Comparator.comparingInt(Integer::intValue).reversed());
        int index = 0, level = 0;
        for (int x = 0; x < Math.ceil((double) numOfFlowers / k); x++) {
            for (int i = 0; i < k && index < numOfFlowers; i++) {
                cost += (level + 1) * c[index++];
            }
            level++;
        }
        return cost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        Integer[] c = new Integer[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
