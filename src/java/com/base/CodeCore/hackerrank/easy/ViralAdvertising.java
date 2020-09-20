package java.com.base.CodeCore.hackerrank.easy;

//https://www.hackerrank.com/challenges/strange-advertising/problem
public class ViralAdvertising {
    static int viralAdvertising(int n) {
        int count = 0;
        int shared = 5;
        int liked = 0;
        for (int i = 0; i < n; i++) {
            liked = shared / 2;
            shared = liked * 3;
            count += liked;
        }
        return count;
    }

    public static void main(String[] args) {
        int res = viralAdvertising(5);
        System.out.println(res);
    }
}
