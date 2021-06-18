package CodeCore.course_dsa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class Hashing {

  public static void main(String[] args) {

    int arr[] = {1, 5, 7, 8, 6, 7, 4, 1, 7, 5, 6, 7, 8, 9, 1};
    System.out.println(checkIfEqualityExist(arr));
    System.out.println(checkIfEqualityExistEfficient(arr));
    System.out.println(minimumEquality(arr));
    System.out.println(findEqualityPairs(arr));
  }

  // Check if pair (i,j) exists in array such that a[i] == a[j]
  private static boolean checkIfEqualityExist(int[] arr) {
    int len = arr.length;
    for (int i = 0; i < len; i++) {
      for (int j = i + 1; j < len; j++) {
        if (arr[i] == arr[j]) {
          return true;
        }
      }
    }
    return false;
  }

  // Check if pair (i,j) exists in array such that a[i] == a[j]
  private static boolean checkIfEqualityExistEfficient(int[] arr) {
    HashSet<Integer> encountered = new HashSet<>();
    for (int i : arr) {
      if (encountered.contains(i)) {
        return true;
      } else {
        encountered.add(i);
      }
    }
    return false;
  }

  // Get minimum value of j-i such that a[i] == a[j]
  private static int minimumEquality(int[] arr) {
    HashMap<Integer, Integer> indexMap = new HashMap<>();
    AtomicInteger minDiff = new AtomicInteger(Integer.MAX_VALUE);
    for (int i = 0; i < arr.length; i++) {
      int finalI = i;
      indexMap.compute(arr[i], (k, v) -> {
        if (v != null) {
          minDiff.set(Math.min(minDiff.get(), finalI - v));
        }
        return finalI;
      });
    }
    return minDiff.get();
  }

  // find count of pairs (i,j) in an array such that a[i] == a[j]
  private static int findEqualityPairs(int[] arr) {
    HashMap<Integer, Integer> freqMap = new HashMap<>();
    AtomicInteger pairs = new AtomicInteger(0);
    for (int i : arr) {
      freqMap.compute(i, (k, v) -> {
        if (v != null) {
          pairs.set(pairs.get() + v);
          return v+1;
        } else {
          return 1;
        }
      });
    }
    return pairs.get();
  }
  
}
