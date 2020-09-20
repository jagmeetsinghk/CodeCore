package CodeCore.hackerrank.medium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

//https://www.hackerrank.com/challenges/count-triplets-1/problem
public class CountGeometricTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> leftMap = new HashMap<>();
        Map<Long, Long> rightMap = new HashMap<>();

        arr.forEach(x -> {
            rightMap.computeIfPresent(x, (k, v) -> v + 1);
            rightMap.putIfAbsent(x, 1L);
        });

        Long result = 0L;

        for (Long mid : arr) {
            Long freq = rightMap.get(mid);
            rightMap.put(mid, freq - 1);

            if (mid % r == 0) {
                Long left = mid / r, right = mid * r;

                Long leftCount = leftMap.get(left);
                Long rightCount = rightMap.get(right);

                if (leftCount != null && rightCount != null) {
                    result += leftCount * rightCount;
                }
            }

            leftMap.computeIfPresent(mid, (k, v) -> v + 1);
            leftMap.putIfAbsent(mid, 1L);
        }
        return result;
    }

    /*
    //Did not clear runtime criteria
    static long countTriplets(List<Long> arr, long r) {
        int len = arr.size();
        long count = 0;
        for (int i = 0; i < len; i++) {
            Long key = arr.get(i), req = key * r;
            for (int j = i + 1; j < len; j++) {
                if (req.equals(arr.get(j))) {
                    key = arr.get(j);
                    req = key * r;
                    for (int k = j + 1; k < len; k++) {
                        if(req.equals(arr.get(k))){
                            count++;
                        }
                    }
                    key = arr.get(i);
                    req = key * r;
                }
            }
        }
        return count;
    }*/

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
