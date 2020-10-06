package CodeCore.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MorseCode {
    private static Map<Character, String> MORSE_CODE1 = new HashMap<>();
    private static Map<String, Character> MORSE_CODE2 = new HashMap<>();
    private static Set<String> MORSE = MORSE_CODE2.keySet();

    static {
        MORSE_CODE1.put('a', ".-");
        MORSE_CODE1.put('b', "-...");
        MORSE_CODE1.put('c', "-.-");
        MORSE_CODE1.put('d', "-..");
        MORSE_CODE1.put('e', ".");
        MORSE_CODE1.put('f', "..-.");
        MORSE_CODE1.put('g', "--.");
        MORSE_CODE1.put('h', "....");
        MORSE_CODE1.put('i', "..");
        MORSE_CODE1.put('j', ".---");
        MORSE_CODE1.put('k', "-.");
        MORSE_CODE1.put('l', ".-..");
        MORSE_CODE1.put('m', "--");
        MORSE_CODE1.put('n', "-.");
        MORSE_CODE1.put('o', "---");
        MORSE_CODE1.put('p', ".--.");
        MORSE_CODE1.put('q', "--.-");
        MORSE_CODE1.put('r', ".-.");
        MORSE_CODE1.put('s', "...");
        MORSE_CODE1.put('t', "-");
        MORSE_CODE1.put('u', "..-");
        MORSE_CODE1.put('v', "...-");
        MORSE_CODE1.put('w', ".--");
        MORSE_CODE1.put('x', "-..-");
        MORSE_CODE1.put('y', "-.--");
        MORSE_CODE1.put('z', "--..");
        MORSE_CODE1.put('1', ".----");
        MORSE_CODE1.put('2', "..---");
        MORSE_CODE1.put('3', "...--");
        MORSE_CODE1.put('4', "....-");
        MORSE_CODE1.put('5', ".....");
        MORSE_CODE1.put('6', "-....");
        MORSE_CODE1.put('7', "--...");
        MORSE_CODE1.put('8', "---..");
        MORSE_CODE1.put('9', "----.");
        MORSE_CODE1.put('0', "-----");
        MORSE_CODE1.forEach((k, v) -> MORSE_CODE2.put(v, k));
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter a word in english alphabet");
        String s = br.readLine();

        String morseCode = englishToMorse(s);

        System.out.format("Given word in MORSE: %s\n", morseCode);

        String morseCodeWithoutSpaces = morseCode.replaceAll("\\s", "");

        System.out.format("Given word in MORSE with lost spaces: %s\n", morseCodeWithoutSpaces);

        List<String> possibilities = new ArrayList<>();
        findPossibilities(morseCodeWithoutSpaces, s.length(), "", possibilities);

        System.out.println(possibilities);
        System.out.println(possibilities.size());
    }

    private static void findPossibilities(String morse, int req_len, String curr, List<String> possibilities) {
        int len = morse.length();
        int curr_len = curr.length();
        if (len > 0) {
            if (curr_len > req_len) return;
            for (String code : MORSE) {
                if (morse.startsWith(code)) {
                    findPossibilities(morse.substring(code.length()), req_len, curr + MORSE_CODE2.get(code), possibilities);
                }
            }
        } else {
            if (curr_len == req_len) {
                possibilities.add(curr);
            } else {
                return;
            }
        }
    }

    private static String englishToMorse(String s) {
        return s.toLowerCase().chars().mapToObj(c -> MORSE_CODE1.get((char) c)).collect(Collectors.joining(" "));
    }

}
