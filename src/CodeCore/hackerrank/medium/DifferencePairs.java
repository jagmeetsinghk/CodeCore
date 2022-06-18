package CodeCore.hackerrank.medium;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://www.hackerrank.com/challenges/pairs/problem
public class DifferencePairs {

    public static void main(String[] args) throws IOException {
        int result = pairs(1, Arrays.asList(363374326, 364147530, 61825163, 1073065718, 1281246024, 1399469912, 428047635, 491595254, 879792181, 1069262793));
        System.out.println(result);
    }

    /*
     * Complete the 'pairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    private static int pairs(int k, List<Integer> arr) {
        Collections.sort(arr);
        int start = 0, end = 1, count = 0;
        while (end < arr.size()) {
            int diff = arr.get(end) - arr.get(start);
            if (diff == k) {
                count++;
                end++;
                start++;
            } else if (diff > k) {
                start++;
            } else {
                end++;
            }
        }
        return count;
    }

}
