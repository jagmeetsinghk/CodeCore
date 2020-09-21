package CodeCore.hackerrank.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

//https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
public class SherlockAndTheValidString {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String s = br.readLine().trim();
        System.out.println(isValid(s));
    }

    static String isValid(String s) {
        HashMap<Character, Integer> charFreq = new HashMap<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        s.chars().forEach(c -> {
            Character key = (char) c;
            Integer val = charFreq.get(key);
            if (val == null) {
                charFreq.put(key, 1);
                freqMap.putIfAbsent(1, 0);
                freqMap.computeIfPresent(1, (k, v) -> v + 1);
            } else {
                charFreq.put(key, val + 1);
                freqMap.computeIfPresent(val, (k, v) -> v - 1);
                freqMap.putIfAbsent(val + 1, 0);
                freqMap.computeIfPresent(val + 1, (k, v) -> v + 1);
            }
        });

        List<Integer> distinctFreq = charFreq.values().stream().distinct().collect(Collectors.toList());
        int distinctCount = distinctFreq.size();
        if (distinctCount > 2)
            return "NO";
        else if (distinctCount == 1) {
            return "YES";
        } else {
            if ((freqMap.getOrDefault(1, 0) == 0 && Math.abs(distinctFreq.get(0) - distinctFreq.get(1)) != 1)
                    || freqMap.get(1) > 1)
                return "NO";
            else return "YES";
        }
    }
}
