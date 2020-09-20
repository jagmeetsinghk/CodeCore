package CodeCore.hackerrank.easy;

//https://www.hackerrank.com/challenges/repeated-string/problem
public class RepeatedString {
    static long repeatedString(String s, long n) {
        long count = 0, len = s.length();

        for (char c : s.toCharArray()) if (c == 'a') count++;

        long quotient = n / len, remainder = n % len;

        count *= quotient;

        for (int i = 0; i < remainder; i++) if (s.charAt(i) == 'a') count++;

        return count;
    }

    public static void main(String[] args) {
        long res = repeatedString("abcac", 10);
        System.out.println(res);
    }
}
