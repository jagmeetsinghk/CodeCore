package CodeCore.hackerrank.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
public class JumpingOnClouds {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] c = Arrays.stream(br.readLine().trim().split("[ ]+")).mapToInt(Integer::parseInt).toArray();
        int steps = 0, index = 0, len = c.length;
        while (index < len - 2) {
            if (c[index + 2] == 0) {
                steps++;
                index += 2;
            } else {
                steps++;
                index++;
            }
        }
        if (index + 1 < len && c[index + 1] == 0) steps++;
        System.out.println(steps);
    }
}
