package CodeCore.hackerrank.easy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/luck-balance/problem
public class LuckBalance {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        int len = contests.length;
        int maxLuck = 0;
        List<Integer> impContests = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (contests[i][1] == 0) maxLuck += contests[i][0];
            else {
                impContests.add(contests[i][0]);
            }
        }
        impContests.sort((a, b) -> b - a);
        int i = 0;
        for (; i < k && i < impContests.size(); i++)
            maxLuck += impContests.get(i);
        for (; i < impContests.size(); i++)
            maxLuck -= impContests.get(i);
        return maxLuck;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
