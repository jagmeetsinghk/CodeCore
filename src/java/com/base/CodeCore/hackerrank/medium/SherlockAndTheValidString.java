package java.com.base.CodeCore.hackerrank.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class SherlockAndTheValidString {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String s = br.readLine().trim();
        System.out.println(isValid(s));
    }

    static String isValid(String s) {
        HashMap<Character, Integer> charFreq = new HashMap<>();
        s.chars().forEach(c -> {
            Integer currentFreq = charFreq.putIfAbsent((char) c, 0);
            charFreq.put((char) c, currentFreq == null ? 1 : currentFreq + 1);
        });

        System.out.println(charFreq);

        List<Integer> distinctFreq = charFreq.values().stream().distinct().collect(Collectors.toList());
        int distinctCount = distinctFreq.size();
        if (distinctCount <= 1)
            return "YES";
        else if (distinctCount > 2)
            return "NO";
        else if ((Math.abs(distinctFreq.get(0) - distinctFreq.get(1)) == 1
                || distinctFreq.stream().anyMatch(f -> (f == 1 && distinctFreq.stream().anyMatch(f1 -> charFreq.values().stream().filter(v -> v == f1).count() == 1)))
        ) && distinctFreq.stream().anyMatch(f -> charFreq.values().stream().filter(v -> v == f).count() == 1))
            return "YES";
        else return "NO";
    }
}
