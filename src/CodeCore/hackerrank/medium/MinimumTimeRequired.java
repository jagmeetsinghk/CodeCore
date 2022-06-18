package CodeCore.hackerrank.medium;

import java.util.Arrays;

//https://www.hackerrank.com/challenges/minimum-time-required/problem
public class MinimumTimeRequired {

    public static void main(String[] args) {
        System.out.println(minTime(new long[]{2, 3}, 5));
    }

    /*
     * 2 3 2
     * 10
     * 2 2 3
     * min 20 max 30
     * mid 25
     * unit = 12 + 12 + 8 = 32
     *
     */
    private static long minTime(long[] machines, long goal) {
        Arrays.sort(machines);
        long max = machines[machines.length - 1];
        long minDays = 0;
        long maxDays = goal * max;
        long res = -1;
        while (minDays < maxDays) {
            long mid = (minDays + maxDays) / 2;
            long unit = 0;
            for (long machine : machines) {
                unit += mid / machine;
            }
            if (unit < goal) {
                minDays = mid + 1;
            } else {
                maxDays = mid;
                res = mid;
            }
        }
        return res;
    }
}
