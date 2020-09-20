package CodeCore.hackerrank.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.hackerrank.com/challenges/non-divisible-subset/problem
public class NonDivisibleSubset {
    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int[] cnts = new int[k];
        int n = s.size();
        for (int i = 0; i < k; ++i) {
            cnts[i] = 0;
        }
        for (int i = 0; i < n; ++i) {
            cnts[s.get(i) % k] += 1;
        }
        int cnt = cnts[0] < 1 ? cnts[0] : 1;
        for (int i = 1; i < k / 2 + 1; ++i) {
            if (i != k - i) {
                cnt += cnts[i] > cnts[k - i] ? cnts[i] : cnts[k - i];
            }
        }
        if (k % 2 == 0) {
            cnt += 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        List<Integer> s = new ArrayList<>(Arrays.asList(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436));
        int res = nonDivisibleSubset(7, s);
		
        System.out.println(res);
    }
}
