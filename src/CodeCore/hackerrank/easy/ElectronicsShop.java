package CodeCore.hackerrank.easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

//https://www.hackerrank.com/challenges/electronics-shop/problem
public class ElectronicsShop {
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        List<Integer> possibilities = new ArrayList<>();
        for (int k : keyboards) {
            for (int d : drives) {
                possibilities.add(k + d);
            }
        }
        Optional<Integer> max = possibilities.stream().filter(possibility -> possibility <= b).max(Comparator.naturalOrder());
        return max.isPresent() ? max.get() : -1;
    }

    public static void main(String[] args) {
        int result = getMoneySpent(new int[]{5}, new int[]{4}, 5);
        System.out.println(result);
    }
}
