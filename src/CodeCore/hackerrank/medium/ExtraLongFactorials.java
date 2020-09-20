package CodeCore.hackerrank.medium;

import java.math.BigInteger;

//https://www.hackerrank.com/challenges/extra-long-factorials/problem
public class ExtraLongFactorials {
    static void extraLongFactorials(int n) {
        BigInteger fact = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        System.out.println(fact);
    }

    public static void main(String[] args) {
        extraLongFactorials(25);
    }
}
