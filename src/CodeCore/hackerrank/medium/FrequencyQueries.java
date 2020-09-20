package CodeCore.hackerrank.medium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.joining;

//https://www.hackerrank.com/challenges/frequency-queries/problem
public class FrequencyQueries {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(int[][] queries) {
        Map<Integer, Integer> keyFreq = new HashMap<>();
        Map<Integer, Integer> freqKey = new HashMap<>();

        List<Integer> output = new ArrayList<>();
        for (int[] query : queries) {
            Integer key = query[1];
            Integer value;
            switch (query[0]) {
                case 1:
                    value = keyFreq.get(key);
                    if (value == null) value = 0;
                    keyFreq.put(key, value + 1);
                    freqKey.computeIfPresent(value, (k, v) -> v - 1);
                    freqKey.computeIfPresent(value + 1, (k, v) -> v + 1);
                    freqKey.putIfAbsent(value + 1, 1);
                    break;
                case 2:
                    value = keyFreq.get(key);
                    if (value != null)
                        if (value > 1) {
                            keyFreq.put(key, value - 1);
                            freqKey.computeIfPresent(value, (k, v) -> v - 1);
                            freqKey.computeIfPresent(value - 1, (k, v) -> v + 1);
                        } else {
                            keyFreq.remove(key);
                            freqKey.computeIfPresent(value, (k, v) -> v - 1);
                        }
                    break;
                case 3:
                    value = freqKey.get(key);
                    if (value != null && value > 0) output.add(1);
                    else output.add(0);
                    break;
            }
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in))) {

            int q = Integer.parseInt(bufferedReader.readLine().trim());
            int[][] queries = new int[q][2];

            for (int i = 0; i < q; i++) {
                String[] query = bufferedReader.readLine().split(" ");
                queries[i][0] = Integer.parseInt(query[0]);
                queries[i][1] = Integer.parseInt(query[1]);
            }

            List<Integer> ans = freqQuery(queries);

            try (BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(System.getenv("OUTPUT_PATH")))) {

                bufferedWriter.write(ans.stream().map(Object::toString)
                        .collect(joining("\n")) + "\n");
            }
        }
    }
}
