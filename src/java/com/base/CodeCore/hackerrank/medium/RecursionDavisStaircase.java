package java.com.base.CodeCore.hackerrank.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Arrays.asList;

//https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem
public class RecursionDavisStaircase {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] ar = new int[n];
            HashSet<Integer> allowedStepSize = new HashSet<>(asList(1, 2, 3));
            int permsWithProvidedStepSize = stepPermsWithProvidedStepSize(n, ar, allowedStepSize);
            System.out.println(permsWithProvidedStepSize);
        }
    }

    private static int stepPermsWithProvidedStepSize(int n, int[] ar, HashSet<Integer> allowedStepSize) {
        if (n < 0) return 0;
        if (n == 1 || n == 0) return 1;
        AtomicInteger result = new AtomicInteger(0);
        allowedStepSize.forEach(e -> {
            if (n - e >= 0) {
                if (ar[n - e] == 0) {
                    ar[n - e] = stepPermsWithProvidedStepSize(n - e, ar, allowedStepSize);
                }
                result.addAndGet(ar[n - e]);
            }
        });
        return result.get();
    }

    private static int stepPerms(int n, int[] ar) {
        if (n < 0) return 0;
        if (n >= 3) {
            if (ar[n - 1] == 0) ar[n - 1] = stepPerms(n - 1, ar);
            if (ar[n - 2] == 0) ar[n - 2] = stepPerms(n - 2, ar);
            if (ar[n - 3] == 0) ar[n - 3] = stepPerms(n - 3, ar);
            return ar[n - 1] + ar[n - 2] + ar[n - 3];
        } else if (n == 2) {
            if (ar[n - 1] == 0) ar[n - 1] = stepPerms(n - 1, ar);
            if (ar[n - 2] == 0) ar[n - 2] = stepPerms(n - 2, ar);
            return ar[n - 1] + ar[n - 2];
        } else return 1;
    }
}