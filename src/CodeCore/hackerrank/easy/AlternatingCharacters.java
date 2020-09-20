package CodeCore.hackerrank.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.hackerrank.com/challenges/alternating-characters/problem
public class AlternatingCharacters {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s = br.readLine().trim();
            int count = alternatingCharacters(s);
            System.out.println(count);
        }
    }

    static int alternatingCharacters(String s) {
        boolean same = true;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = i + 1; j < s.length() && s.charAt(j) == c; j++) {
                count++;
                i++;
            }
        }
        return count;
    }
}
