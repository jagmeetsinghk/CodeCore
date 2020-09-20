package java.com.base.CodeCore.hackerrank.easy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//https://www.hackerrank.com/challenges/cut-the-sticks/problem
public class CutTheSticks {
    static List<Integer> cutTheSticks(List<Integer> arr) {
        List<Integer> answer = new ArrayList<>();
        arr.sort(Comparator.naturalOrder());
        while (!arr.isEmpty()) {
            answer.add(arr.size());
            int min = arr.get(0);
            arr = arr.stream().map(i -> i = i - min).filter(i -> i > 0).collect(Collectors.toList());
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        cutTheSticks(Arrays.asList(5, 4, 4, 2, 2, 8)).forEach(i -> System.out.print(i + " "));
    }
}
