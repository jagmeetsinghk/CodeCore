package CodeCore.hackerrank.easy;

//https://www.hackerrank.com/challenges/find-digits/problem
public class FindDigits {

    static int findDigits(int n) {
        int count = 0;
        int[] digits = (n + "").chars().map(i -> i = i - 48).toArray();
        for (int i : digits) {
            if (i == 0) continue;
            else if (i == 1) count++;
            else if (n % i == 0) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int res = findDigits(1012);
        System.out.println(res);
    }
}
