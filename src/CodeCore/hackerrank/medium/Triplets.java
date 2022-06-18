package CodeCore.hackerrank.medium;

import java.util.Arrays;

//https://www.hackerrank.com/challenges/triple-sum/problem
public class Triplets {

    public static void main(String[] args) {
        long triplets = triplets(new int[]{1, 3, 5}, new int[]{2, 3}, new int[]{1, 2, 3});
        System.out.println(triplets);
    }

    static long triplets(int[] a, int[] b, int[] c) {
        a = Arrays.stream(a).sorted().distinct().toArray();
        b = Arrays.stream(b).sorted().distinct().toArray();
        c = Arrays.stream(c).sorted().distinct().toArray();

        long triplets = 0;

        int i = 0, j = 0, k = 0;
        while (j < b.length) {
            while (i < a.length && a[i] <= b[j]) {
                i++;
            }
            while (k < c.length && c[k] <= b[j]) {
                k++;
            }
            triplets += (long) i * k;
            j++;
        }

        return triplets;
    }
}
