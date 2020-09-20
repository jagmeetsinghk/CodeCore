package java.com.base.CodeCore.hackerrank.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FormingAMagicSquare {

    static int formingMagicSquare(int[][] s) {
        List<Integer> diffs = new ArrayList<>();
        int[][][] magicSquares = {
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
        };
        for (int[][] magicSq : magicSquares) {
            int cost = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    cost += Math.abs(magicSq[i][j] - s[i][j]);
                }
            }
            diffs.add(cost);
        }
        return diffs.stream().min(Comparator.naturalOrder()).get();
    }

    public static void main(String[] args) {
        int result = formingMagicSquare(new int[][]{{4, 8, 2}, {4, 5, 7}, {6, 1, 6}});
        System.out.println(result);
    }
}
