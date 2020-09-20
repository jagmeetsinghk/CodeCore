package CodeCore.hackerrank.easy;

//https://www.hackerrank.com/challenges/drawing-book/problem
public class DrawingBook {

    static int pageCount(int n, int p) {
        int fromStart = p / 2;
        int fromEnd = n % 2 == 0 ? (n - p + 1) / 2 : (n - p) / 2;
        return fromStart < fromEnd ? fromStart : fromEnd;
    }

    public static void main(String[] args) {
        int result = pageCount(5, 4);
        System.out.println(result);
    }

}
