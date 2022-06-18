package CodeCore.hackerrank.medium;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem
public class IceCreamParlour {

    public static void main(String[] args) throws IOException {
        whatFlavors(Arrays.asList(1, 4, 5, 3, 2), 5);
    }

    /*
     * Complete the 'whatFlavors' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY cost
     *  2. INTEGER money
     */

    public static void whatFlavors(List<Integer> cost, int money) {
        HashMap<Integer, Integer> hashedCosts = new HashMap<>();
        for (int i = 0; i < cost.size(); i++) {
            Integer temp = money - cost.get(i);
            if (hashedCosts.containsKey(temp)) {
                System.out.println(hashedCosts.get(temp) + "  " + (i + 1));
                return;
            } else {
                hashedCosts.put(cost.get(i), i + 1);
            }
        }
    }
}
