package java.com.base.CodeCore.hackerrank.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


//https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
public class ClimbingTheLeaderBoard {
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int scoresSize = scores.length;
        int aliceLength = alice.length;

        int[] res = new int[aliceLength];
        int[] rank = new int[scoresSize];

        rank[0] = 1;

        for (int i = 1; i < scoresSize; i++) {
            if (scores[i] == scores[i - 1]) {
                rank[i] = rank[i - 1];
            } else {
                rank[i] = rank[i - 1] + 1;
            }
        }

        for (int i = 0; i < aliceLength; i++) {
            int aliceScore = alice[i];
            if (aliceScore > scores[0]) {
                res[i] = 1;
            } else if (aliceScore < scores[scoresSize - 1]) {
                res[i] = rank[scoresSize - 1] + 1;
            } else {
                int index = binarySearch(scores, aliceScore);
                res[i] = rank[index];
            }
        }
        return res;

    }

    private static int binarySearch(int[] a, int key) {

        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] < key && key < a[mid - 1]) {
                return mid;
            } else if (a[mid] > key && key >= a[mid + 1]) {
                return mid + 1;
            } else if (a[mid] < key) {
                hi = mid - 1;
            } else if (a[mid] > key) {
                lo = mid + 1;
            }
        }
        return -1;
    }

    static List<Integer> climbingLeaderboard(List<Integer> scores, List<Integer> alice) {
        List<Integer> distinctScores = scores.stream().distinct().collect(Collectors.toList());
        return alice.stream().map(aliceScore -> aliceScore = Collections.binarySearch(distinctScores, aliceScore, (x, y) -> y - x)).map(pos -> pos = pos >= 0 ? pos + 1 : Math.abs(pos)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Long startTime, endTime;

        startTime = System.currentTimeMillis();
        List<Integer> res1 = climbingLeaderboard(Arrays.asList(100, 100, 50, 40, 40, 20, 10), Arrays.asList(5, 25, 50, 120));
        endTime = System.currentTimeMillis();
        res1.forEach(rank -> System.out.println(rank));
        System.out.println("Time taken: " + (endTime - startTime));

        System.out.println("----------------------------");
        startTime = System.currentTimeMillis();
        int[] res2 = climbingLeaderboard(new int[]{100, 100, 50, 40, 40, 20, 10}, new int[]{5, 25, 50, 120});
        endTime = System.currentTimeMillis();
        Arrays.stream(res2).forEach(rank -> System.out.println(rank));
        System.out.println("Time taken: " + (endTime - startTime));

    }
}
