package CodeCore.hackerrank.medium;

import java.util.HashMap;
import java.util.Scanner;

//https://web.stanford.edu/class/cs9/sample_probs/TwoSum.pdf
//https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem
public class HashTablesIceCreamParlor {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0, len = cost.length; i < len; i++) {
            if (map.containsKey(money - cost[i])) {
                System.out.println((map.get(money - cost[i]) + 1) + " " + (i + 1));
            }
            map.put(cost[i], i);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}

