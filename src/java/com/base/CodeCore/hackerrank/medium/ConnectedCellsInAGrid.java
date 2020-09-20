package java.com.base.CodeCore.hackerrank.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ConnectedCellsInAGrid {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int connectedCell(int[][] matrix) {
        int max = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                int surrounding = getConnectCells(matrix, row, column);
                if (surrounding > max) max = surrounding;
            }
        }
        return max;
    }

    private static int getConnectCells(int[][] matrix, int row, int column) {
        if (row < 0 || row >= matrix.length || column < 0 || column >= matrix[row].length) return 0;
        if (matrix[row][column] == 0) return 0;
        matrix[row][column] = 0;
        int onesInGroup = 1;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                onesInGroup += getConnectCells(matrix, i, j);
            }
        }
        return onesInGroup;
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        int m = Integer.parseInt(br.readLine().trim());
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(br.readLine().trim().split("[ ]+")).mapToInt(Integer::parseInt).toArray();
        }

        int result = connectedCell(matrix);

        System.out.println(result);
    }
}
