package CodeCore.course_dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Recursion {

  void recursion(int x) {
    if (x <= 0) {
      return;
    }
    recursion(x - 1);
  }

  public static void main(String[] args) {

    int n = 123;

    System.out.println("--------Print of 1 to n");
    print1ToN(n);
    System.out.println();

    System.out.println("--------Print of n to 1");
    printNto1(n);
    System.out.println();

    System.out.println("--------Sum of 1 to n");

    int sum = getSumOfN(n);
    System.out.println("Sum of 1 to " + n + " is: " + sum);

    System.out.println("--------Palindrome check");
    String[] strs = {"aba", "abba", "ababa", "abakjsfb", "hih", "sbdjk", "iuahjbkevdnscx"};
    Arrays.stream(strs)
        .forEach(s -> System.out.println(s + " is palindrome? : " + checkPalindrome(s)));
    System.out.println("--------Sum of digits");

    System.out.println("Sum of digits of " + n + " is: " + sumOfDigits(n));

    System.out.println("--------MaxCuts - Rope Cutting Problem");
    int a = 2, b = 2, c = 2;
    n = 9;
    System.out.println(
        "Rope cutting solution for n = " + n + ", a = " + a + "  , b = " + b + ", c = " + c + ": "
            + maxCuts(n, a, b, c));

    System.out.println("--------Subset");
    String s = "ABC";
    Set<String> subset = new HashSet<>();
    getSubsets(s, subset);
    System.out.println("Subset of " + s + ": " + subset);

    System.out.println("--------Subset - GFG Way");
    subset.clear();
    getSubsets(s, "", 0, subset);
    System.out.println("Subset of " + s + ": " + subset);

    System.out.println("--------Tower of Hanoi 3 disks");
    towerOfHanoi(3, 1, 3, 2);

    System.out.println("--------Josephus Problem");
    n = 5;
    int k = 3;
    System.out
        .println("Survivor when n = " + n + " and k = " + k + " is: " + josephusSurvivor(n, k));

    System.out.println("--------Subset Sum Problem");
    List<Integer> actual = Arrays.stream(new int[]{10, 25, 15}).mapToObj(Integer::valueOf).collect(
        Collectors.toList());
    sum = 25;
    System.out.print("Subsets of " + actual + " with sum " + sum + " are: ");
    printSubsetWithSumEquals(actual, new ArrayList<>(), 0, sum);
    System.out.println();

    System.out.println("--------Permutations of string");
    s = "ABC";
    System.out.print("Permutations of " + s + " are: [");
    printAllPermutations(s, 0);
    System.out.print("\b\b]");

    System.out.println();
    System.out.println("--------");
    ArrayList<String> result = Solution.possibleWords(new int[]{2, 1, 5}, 3);
    System.out.println(result);

    System.out.println("--------Is Lucky?");
    System.out.println(isLucky(19, 2));

    ArrayList<String> pSet = new ArrayList<>();
    powerSet(s, "", 0, pSet);
    System.out.println(pSet);
  }
  //Function to return the lexicographically sorted power-set of the string.


  private static final List<String> T9 = List
      .of("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");

  //Function to find list of all words possible by pressing given numbers.
  static ArrayList<String> possibleWords(int a[], int n) {
    ArrayList<String> result = new ArrayList<>();
    possibleWords(a, "", 0, result);
    return result;
  }

  private static void possibleWords(int[] a, String s, int ii, ArrayList<String> result) {
    int length = a.length;
    if (ii == length) {
      result.add(s);
      return;
    }
    for (char c : T9.get(a[ii]).toCharArray()) {
      possibleWords(a, s + c, ii + 1, result);
    }
  }

  private static void powerSet(String s, String curr, int i, List<String> pSet) {
    if (i == s.length()) {
      pSet.add(curr);
      return;
    }
    powerSet(s, curr, i + 1, pSet);
    powerSet(s, curr + s.charAt(i), i + 1, pSet);
  }

  long power(int n, int r) {
    if (r == 0) {
      return 1L;
    }
    return (n * power(n, r - 1));
  }

  static int recursivePower(int n, int p) {
    if (n == 0) {
      return 0;
    }
    if (p == 0) {
      return 1;
    }
    int res;
    if ((p & 1) == 0) {
      res = recursivePower(n, p >> 1);
      res = res * res;
    } else {
      res = n * recursivePower(n, p - 1);
    }
    return res;
  }

  static boolean isLucky(int n, int counter) {
    if (n % counter == 0) {
      return false;
    }
    if (n < counter) {
      return true;
    }
    int newPos = n - n / counter;
    return isLucky(newPos, counter + 1);
  }

  private static void printAllPermutations(String s, int i) {
    int length = s.length();
    if (length - 1 == i) {
      System.out.print(s + ", ");
      return;
    }
    for (int ii = i; ii < length; ii++) {
      String s1 = swap(s, i, ii);
      printAllPermutations(s1, i + 1);
    }
  }

  private static String charArrayToString(char[] s) {
    StringBuilder sb = new StringBuilder();
    for (char c : s) {
      sb.append(c);
    }
    return sb.toString();
  }

  private static String swap(String s, int a, int b) {
    char[] arr = s.toCharArray();
    char temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
    return charArrayToString(arr);
  }

  private static void printSubsetWithSumEquals(List<Integer> actual, List<Integer> curr, int i,
      int sum) {
    if (actual.size() == i) {
      if (curr.stream().mapToInt(a -> a).sum() == sum) {
        System.out.print(curr + " ");
      }
      return;
    }
    printSubsetWithSumEquals(actual, curr, i + 1, sum);
    List<Integer> newCurr = new ArrayList<>(curr);
    newCurr.add(actual.get(i));
    printSubsetWithSumEquals(actual, newCurr, i + 1, sum);
  }

  private static int josephusSurvivor(int n, int k) {
    if (n == 0) {
      return 0;
    }
    return (josephusSurvivor(n - 1, k) + k) % n;
  }

  private static void towerOfHanoi(int n, int source, int destination, int arbitrary) {

    if (n <= 1) {
      System.out.println("Move from position " + source + " to position " + destination);
      return;
    }
    towerOfHanoi(n - 1, source, arbitrary, destination);
    towerOfHanoi(1, source, destination, arbitrary);
    towerOfHanoi(n - 1, arbitrary, destination, source);
  }

  public static void getSubsets(String s, Set<String> subset) {
    int length = s.length();
    if (length == 0) {
      subset.add("");
      return;
    }
    subset.add(s);
    for (int i = 0; i < length; i++) {
      getSubsets(new StringBuilder(s).replace(i, i + 1, "").toString(), subset);
    }
  }

  private static int maxCuts(int n, int a, int b, int c) {

    if (n < 0) {
      return -1;
    }
    if (n == 0) {
      return 0;
    }

    int withA = maxCuts(n - a, a, b, c);
    int withB = maxCuts(n - b, a, b, c);
    int withC = maxCuts(n - c, a, b, c);

    int maxCuts = Math.max(withA, Math.max(withB, withC));
    return maxCuts == -1 ? -1 : maxCuts + 1;
  }

  private static int sumOfDigits(int n) {
    if (n <= 9) {
      return n;
    }
    return n % 10 + sumOfDigits(n / 10);
  }

  private static boolean checkPalindrome(String s) {
    final int length = s.length();
    if (length == 0 || length == 1) {
      return true;
    }
    return (s.charAt(0) == s.charAt(length - 1)) && checkPalindrome(s.substring(1, length - 1));
  }

  private static int getSumOfN(int n) {
    if (n < 0) {
      throw new RuntimeException("Out of bounds");
    }
    if (n == 0) {
      return 0;
    }
    return n + getSumOfN(n - 1);
  }

  private static void printNto1(int n) {
    if (n == 0) {
      return;
    }
    System.out.print(n + " ");
    printNto1(n - 1);
  }

  private static void print1ToN(int n) {
    if (n == 0) {
      return;
    }
    print1ToN(n - 1);
    System.out.print(n + " ");
  }

  private static void getSubsets(String s, String curr, int i, Set<String> subsets) {
    if (i == s.length()) {
      subsets.add(curr);
      return;
    }
    getSubsets(s, curr, i + 1, subsets);
    getSubsets(s, curr + s.charAt(i), i + 1, subsets);
  }

}

class Solution {

  private static final List<String> T9 = List
      .of("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");

  //Function to find list of all words possible by pressing given numbers.
  static ArrayList<String> possibleWords(int a[], int n) {
    ArrayList<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    possibleWords(a, "", 0, result);
    return result;
  }

  private static void possibleWords(int[] a, String s, int ii, ArrayList<String> result) {
    int length = a.length;
    if (ii == length) {
      result.add(s);
      return;
    }
    for (char c : T9.get(a[ii]).toCharArray()) {
      possibleWords(a, s + c, ii + 1, result);
    }
  }


}