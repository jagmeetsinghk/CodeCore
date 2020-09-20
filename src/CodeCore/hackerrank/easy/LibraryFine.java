package CodeCore.hackerrank.easy;

//https://www.hackerrank.com/challenges/library-fine/problem
public class LibraryFine {
    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        Integer fine = 0;
        if (y1 < y2) {
            fine = 0;
        } else if (y1 == y2) {
            if (m1 < m2) {
                fine = 0;
            } else if (m1 == m2) {
                if (d1 <= d2) {
                    fine = 0;
                } else {
                    fine = 15 * (d1 - d2);
                }
            } else {
                fine = 500 * (m1 - m2);
            }
        } else {
            fine = 10000;
        }
        return fine;
    }

    public static void main(String[] args) {
        int fine = libraryFine(28, 2, 2015, 15, 4, 2015);
        System.out.println(fine);
    }
}
