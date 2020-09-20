package CodeCore.hackerrank.easy;

import java.util.Arrays;
import java.util.List;

//https://www.hackerrank.com/challenges/bon-appetit/problem
public class BonAppetit {
    static void bonAppetit(List<Integer> bill, int k, int b) {
        System.out.println((bill.stream().mapToInt(Integer::intValue).sum() - bill.get(k)) / 2);
    }

    public static void main(String[] args) {
        bonAppetit(Arrays.asList(4, 4, 5, 5), 2, 4);
    }
}
