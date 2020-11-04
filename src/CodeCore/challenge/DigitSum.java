package CodeCore.challenge;

public class DigitSum {
    public static void main(String[] args) {
        int n = 9875;
        int k = 4;
        System.out.println(digitSum(n, k));
    }

    private static int digitSum(int n, int k){
        int rem = ((n+"").chars().map(i -> i-48).sum() * k) % 9;
        return rem == 0 ? 9 : rem;
    }
}
