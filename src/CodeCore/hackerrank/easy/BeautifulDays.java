package CodeCore.hackerrank.easy;

//https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
public class BeautifulDays {
    static int beautifulDays(int i, int j, int k) {
        int count = 0;
        while (i <= j) {
            if ((i - Integer.parseInt(new StringBuffer(i + "").reverse().toString())) % k == 0) {
                count++;
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        int res = beautifulDays(20, 23, 6);
        System.out.println(res);
    }
}
