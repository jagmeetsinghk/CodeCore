package java.com.base.CodeCore.hackerrank.easy;

//https://www.hackerrank.com/challenges/counting-valleys/problem
public class CountingValleys {
    static int countingValleys(int n, String s) {
        int level = 0;
        boolean flag = false;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'U') level += 1;
            else level -= 1;
            if (level < 0) flag = true;
            if (level == 0 && flag == true) {
                count++;
                flag = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int result = countingValleys(8, "UDDDUDUU");
        System.out.println(result);
    }
}
