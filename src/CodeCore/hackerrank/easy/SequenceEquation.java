package CodeCore.hackerrank.easy;

import java.util.Arrays;

//https://www.hackerrank.com/challenges/permutation-equation/problem
public class SequenceEquation {
    static int[] permutationEquation(int[] p) {
        int[] res = new int[p.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = find(p, find(p, i + 1));
        }
        return res;
    }

    static int find(int[] a, int k) {
        int pos = -1;
        for (int i = 0; i < a.length; i++) if (a[i] == k) pos = i + 1;
        return pos;
    }

    public static void main(String[] args) {
        int[] res = permutationEquation(new int[]{1, 3, 5, 4, 2});
        Arrays.stream(res).forEach(i -> System.out.println(i));
    }
}
