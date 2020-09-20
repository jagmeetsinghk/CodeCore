package CodeCore.hackerrank.easy;

import java.util.*;

//https://www.hackerrank.com/challenges/picking-numbers/problem
public class PickingNumbers {
    public static int pickingNumbers(List<Integer> a) {
        List<List<Integer>> possibilities = new ArrayList<>();
        List<Integer> done = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if (!done.contains(a.get(i))) {
                List<Integer> minusList = new ArrayList<>();
                List<Integer> plusList = new ArrayList<>();
                for (int j = 0; j < a.size(); j++) {
                    if (a.get(j).equals(a.get(i)) || a.get(j).equals(a.get(i) + 1)) {
                        plusList.add(a.get(j));
                    } else if (a.get(i) != 0 && (a.get(j).equals(a.get(i)) || a.get(j).equals(a.get(i) - 1))) {
                        minusList.add(a.get(j));
                    }
                }
                possibilities.add(minusList);
                possibilities.add(plusList);
                done.add(a.get(i));
            }
        }
        Optional<List<Integer>> maxList = possibilities.stream().max(Comparator.comparingInt(x -> x.size()));
        return maxList.isPresent() ? maxList.get().size() : 1;
    }

    public static void main(String[] args) {
        int result = pickingNumbers(Arrays.asList(14, 18, 17, 10, 9, 20, 4, 13, 19, 19, 8, 15, 15, 17, 6, 5, 15, 12, 18, 2, 18, 7, 20, 8, 2, 8, 11, 2, 16, 2, 12, 9, 3, 6, 9, 9, 13, 7, 4, 6, 19, 7, 2, 4, 3, 4, 14, 3, 4, 9, 17, 9, 4, 20, 10, 16, 12, 1, 16, 4, 15, 15, 9, 13, 6, 3, 8, 4, 7, 14, 16, 18, 20, 11, 20, 14, 20, 12, 15, 4, 5, 10, 10, 20, 11, 18, 5, 20, 13, 4, 18, 1, 14, 3, 20, 19, 14, 2, 5, 13));
        System.out.println(result); //15
    }
}
