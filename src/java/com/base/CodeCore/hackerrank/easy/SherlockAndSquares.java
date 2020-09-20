package java.com.base.CodeCore.hackerrank.easy;

//https://www.hackerrank.com/challenges/sherlock-and-squares/problem
public class SherlockAndSquares {
    static int squares(int a, int b) {
        int count = 0, iter = a, i = -1;
        while (true) {
            if (iter <= b) {
                float sqrt = (float) Math.pow(iter, 0.5);
                int roundedSqrt = Math.round(sqrt);
                if (sqrt == roundedSqrt) {
                    i = roundedSqrt;
                    break;
                }
                iter++;
            } else {
                return 0;
            }
        }
        while (iter <= b) {
            count++;
            iter += i++ + i;
        }
        return count;
    }

    public static void main(String[] args) {
        int res = squares(17, 24);
        System.out.println(res);
    }
}
