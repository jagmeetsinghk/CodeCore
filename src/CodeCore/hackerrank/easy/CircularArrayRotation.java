package CodeCore.hackerrank.easy;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Arrays.stream;

//https://www.hackerrank.com/challenges/circular-array-rotation/problem
public class CircularArrayRotation {

    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int length = a.length;
        k = k % length;
        int[] temp = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            temp[i] = a[i - k >= 0 ? i - k : length + i - k];
        }
        AtomicInteger i = new AtomicInteger();
        Arrays.stream(queries).forEach(q -> queries[i.getAndIncrement()] = temp[q]);
        return queries;
    }

    public static void main(String[] args) {
        int[] res = circularArrayRotation(new int[]{3, 4, 5}, 2, new int[]{0, 2});
        stream(res).forEach(i -> System.out.print(i + " "));
    }
}
