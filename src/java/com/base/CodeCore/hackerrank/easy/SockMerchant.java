package java.com.base.CodeCore.hackerrank.easy;

import java.util.HashMap;
import java.util.Map;

//https://www.hackerrank.com/challenges/sock-merchant/problem
public class SockMerchant {
    static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> socks = new HashMap<>();
        for (int i : ar) {
            socks.computeIfPresent(i, (k, v) -> v += 1);
            socks.computeIfAbsent(i, k -> 1);
        }
        int pairs = 0;
        for (Integer value : socks.values()) {
            int unitPairs = value / 2;
            pairs += unitPairs;
        }
        return pairs;
    }

    public static void main(String[] args) {
        int result = sockMerchant(9, new int[]{1, 2, 1, 2, 1, 3, 2});
        System.out.println(result);
    }
}
