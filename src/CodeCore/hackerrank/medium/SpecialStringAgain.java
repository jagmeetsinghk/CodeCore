package CodeCore.hackerrank.medium;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/special-palindrome-again/problem
public class SpecialStringAgain {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        List<SimpleEntry<Character, Integer>> entries = new ArrayList<>();
        Character curr = s.charAt(0);
        Integer count = 0, result = 0;
        for (int i = 0; i < n; i++) {
            while (i < n && s.charAt(i) == curr) {
                count++;
                i++;
            }
            entries.add(new SimpleEntry(curr, count));
            if (i < n) curr = s.charAt(i);
            result += count * (count +1) / 2;
            count = 0;
            i--;
        }
        for(int i = 1; i < entries.size()-1; i++){
            if(entries.get(i).getValue() == 1){
                if(entries.get(i-1).getKey() == entries.get(i+1).getKey()){
                    result += Math.min(entries.get(i-1).getValue(), entries.get(i+1).getValue());
                }
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
