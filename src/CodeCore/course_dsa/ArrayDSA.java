package CodeCore.course_dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayDSA {
  /*
   * Array is a collection of similar type elements stored in contiguous locations.
   *
   * Pending Questions
   * Count distinct elements in every window of size k. O(n) - Uses hashing | LATER
   * Check if a subarray exist with sum 0 (hashing)
   * Find longest sub arrays with equal 0's and 1's in an array of 0' sand 1's only as domain. (hashing)
   *
   */

  public static void main(String[] args) {
    ArrayDSA arrayDSA = new ArrayDSA();
    Integer[] arr = {1, 2, 3, 1, 2, 3, 3, 2, 1};
    System.out
        .println(arrayDSA.isSorted(arr) ? "Array is sorted" : "Array is not sorted");
    arrayDSA.removeDuplicatesFromSortedArray(arr);
    System.out.print("Removed duplicates: ");
    printArray(arr);
    arr = new Integer[]{1, 0, 0, 0, 2, 3, 4, 0};
    arrayDSA.moveZerosToEnd(arr);
    System.out.print("Moved zeros to end: ");
    printArray(arr);
    arr = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    arrayDSA.leftSingleCyclicRotation(arr);
    System.out.print("Left Single Rotation: ");
    printArray(arr);
    arrayDSA.rightSingleCyclicRotation(arr);
    System.out.print("Right Single Rotation: ");
    printArray(arr);
    arrayDSA.leftCyclicRotation(arr, 4);
    System.out.print("Left Rotation by 4 places: ");
    printArray(arr);

    System.out.print("Leaders in array: ");
    arrayDSA.findLeadersInArray(arr);

    System.out.println(
        "Max Difference a[j] - a[i]: j > i [O(n2)]: " + arrayDSA.maxDifferenceOn2(arr));

    System.out.println(
        "Max Difference a[j] - a[i]: j > i [O(n)]: " + arrayDSA.maxDifference(arr));

    arr = new Integer[]{1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 5};
    System.out.print("Frequencies in sorted array: ");
    arrayDSA.frequenciesInArray(arr);

    arr = new Integer[]{1, 5, 9};
    System.out.println("Stock Buy and Sell: " + arrayDSA.profitByStockBuyAndSell(arr));

    System.out.println("Trapped rain water: " + arrayDSA.trapRainWater(arr));

    arr = new Integer[]{1, 5, -3, 7, 3, -4, 8};

    System.out.println("Max sub array sum: " + arrayDSA.maxSubArraySum(arr));

    System.out.print("Longest even odd subarray: ");
    System.out
        .println(longestEvenOddSubArray(new int[]{1, 2, 1, 2, 1, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1, 2}));

    System.out.println("Majority Candidate: " + potentialMajority(
        new int[]{8, 8, 9, 9, 8, 8, 9, 9, 8, 8, 8, 9, 9, 8, 7}));

    System.out.println("Minimum Consecutive Flips: ");
    minimumConsecutiveFlips(new int[]{1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0});
    System.out.println();
    System.out.println("------------------");
    printNBonacchiNumbers(2, 10);

    arr = new Integer[]{2, 4, 5, 6, 7, 8, 9};
    printArray(arr);
    SumSumOfSubArrayUsingPrefixSum(arr, new Integer[]{0, 5, 1, 6, 3, 6, 6, 6, 4, 6});

    System.out.println("Equilibrium of arr: " + checkIfArrayHasAnEquilibriumPoint(arr));

    arr = new Integer[]{2, 4, 5, 4, 7, 8, 3};
    System.out.println("Can be divided into 3 parts with equal sum? "
        + checkIfArrayCanBeDividedInto3SubArraysWithEqualSum(arr));

    arr = new Integer[]{2, 1, 2};
    System.out.println("Second Largest: " + getSecondLargestInArray(arr));

    System.out.println("---------");
    System.out.println(maxOccured(new int[]{1, 4, 3, 1}, new int[]{15, 8, 5, 4}, 4, 15));

    System.out.println("------------------");
    int[] ar = new int[]{5, 2, 1, 4, 1};
    frequencyInArray(ar);
    for (int i : ar) {
      System.out.print(i + " ");
    }

  }

  // Print array space seperated
  private static <T> void printArray(T[] arr) {
    System.out.print("[");
    for (T t : arr) {
      System.out.print(t + ", ");
    }
    System.out.println("\b\b]");
  }

  // Largest element in array
  int getLargestElementInArray(int[] arr) {
    int max = arr[0];
    for (int i : arr) {
      max = Math.max(max, i);
    }
    return max;
  }

  // Second largest element in array
  private static Integer getSecondLargestInArray(Integer[] arr) {
    Integer secondLargest = null;
    int largest = arr[0];
    for (Integer i : arr) {
      if (i > largest) {
        secondLargest = largest;
        largest = i;
      }
    }
    return secondLargest;
  }

  // Check if array is sorted
  <T extends Comparable> boolean isSorted(T[] arr) {
    int length = arr.length;
    for (int i = 1; i < length; i++) {
      if (arr[i].compareTo(arr[i - 1]) < 1) {
        return false;
      }
    }
    return true;
  }

  // Reverse an array
  <T> void reverseArray(T[] arr, int start, int end) {
    if (start >= end) {
      return;
    }
    swapElements(arr, start, end);
    reverseArray(arr, start + 1, end - 1);
  }

  // Swap elements in array
  private <T> void swapElements(T[] arr, int a, int b) {
    T temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  // Remove duplicates from a sorted array
  <T extends Comparable> void removeDuplicatesFromSortedArray(T[] arr) {
    if (!isSorted(arr)) {
      Arrays.sort(arr);
    }
    int length = arr.length;
    int curr = 0;
    for (int i = 0; i < length; i++) {
      while (i < length - 1 && arr[i].equals(arr[i + 1])) {
        i++;
      }
      swapElements(arr, curr, i);
      curr++;
    }
    for (int i = curr; i < length; i++) {
      arr[i] = null;
    }
  }

  //  Move zeros to end
  void moveZerosToEnd(Integer[] arr) {
    int length = arr.length;
    int curr = 0;
    for (int i = 0; i < length; i++) {
      while (i < length - 1 && arr[i] == 0) {
        i++;
      }
      swapElements(arr, curr, i);
      curr++;
    }
  }

  //  Right Rotation (Cyclic)
  <T> void rightSingleCyclicRotation(T[] arr) {
    T temp = arr[arr.length - 1];
    for (int i = arr.length - 1; i > 0; i--) {
      arr[i] = arr[i - 1];
    }
    arr[0] = temp;
  }

  // Left rotation (Cyclic)
  <T> void leftSingleCyclicRotation(T[] arr) {
    T temp = arr[0];
    for (int i = 0; i < arr.length - 1; i++) {
      arr[i] = arr[i + 1];
    }
    arr[arr.length - 1] = temp;
  }

  //   Left rotation by d places (Cyclic) {reverse 0 -> d-1, reverse d -> n-1, reverse 0 -> n-1}
  <T> void leftCyclicRotation(T[] arr, int d) {
    reverseArray(arr, 0, d - 1);
    reverseArray(arr, d, arr.length - 1);
    reverseArray(arr, 0, arr.length - 1);
  }

  //    Leaders in Array {leader: all elements on right are smaller}
  void findLeadersInArray(Integer[] arr) {
    int length = arr.length, max = arr[length - 1];
    List<Integer> leaders = new ArrayList<>();
    leaders.add(max);
    for (int i = length - 2; i >= 0; i--) {
      if (arr[i] > max) {
        leaders.add(arr[i]);
      }
      max = Math.max(max, arr[i]);
    }
    System.out.println(leaders);
  }

  //  Maximum Difference {max a[j] - a[i]: j > i}
  Integer maxDifferenceOn2(Integer[] arr) {
    int length = arr.length, max = Integer.MIN_VALUE;
    for (int i = 0; i < length; i++) {
      for (int j = i + 1; j < length; j++) {
        max = Math.max(arr[j] - arr[i], max);
      }
    }
    return max;
  }

  //  Maximum Difference {max a[j] - a[i]: j > i}
  Integer maxDifference(Integer[] arr) {
    int min = arr[0];
    int max = arr[1] - arr[0];
    for (int i = 1; i < arr.length; i++) {
      max = Math.max(arr[i] - min, max);
      min = Math.min(arr[i], min);
    }
    return max;
  }

  //  Frequencies in Sorted Array
  void frequenciesInArray(Integer[] arr) {
    Map<Integer, Integer> frequencies = new HashMap<>();
    Arrays.stream(arr).forEach(i -> frequencies.compute(i, (k, v) -> v == null ? 1 : v + 1));
    System.out.println(frequencies);
  }

  /**
   * Given stock prices for next n number of days. This method returns the maximum profit we can get
   * out of trading on these stocks.
   *
   * @param arr array of stock prices for next n days
   * @return maximum profit by trading on stocks provided
   */
  //  Stock buy and sell (int[] stockPrices)
  Integer profitByStockBuyAndSell(Integer[] arr) {
    int bought = 0, profit = 0;
    for (int i = 0; i < arr.length; i++) {
      if (bought == 0) {
        while (i < arr.length - 1 && arr[i] >= arr[i + 1]) {
          i++;
        }
        bought = arr[i];
      } else {
        while (i < arr.length - 1 && arr[i] <= arr[i + 1]) {
          i++;
        }
        profit += arr[i] - bought;
        bought = 0;
      }
    }
    return profit;
  }

  /**
   * Given number of blocks and their lengths which are kept side by side to trap rain water. This
   * method returns the amout of water that system can trap.
   *
   * @param arr array of integers defining length of blocks
   * @return units of water the system can trap
   */
  // Trapping Rain Water (array contain non negative integers as height of bars. Calciulate water that can be stored)
  Integer trapRainWater(Integer[] arr) {
    int length = arr.length, trappedWater = 0;
    int[] lMax = new int[length];
    int[] rMax = new int[length];
    lMax[0] = arr[0];
    rMax[length - 1] = arr[length - 1];
    for (int i = 1; i < length; i++) {
      lMax[i] = Math.max(lMax[i - 1], arr[i]);
    }
    for (int i = length - 2; i >= 0; i--) {
      rMax[i] = Math.max(rMax[i + 1], arr[i]);
    }
    for (int i = 0; i < length; i++) {
      trappedWater += Math.min(lMax[i], rMax[i]) - arr[i];
    }
    return trappedWater;
  }

  /**
   * Maximum sum sub-array using Kadane's algorithm.
   *
   * @param arr of integers
   * @return sum of sub-array having maximum sum in array arr
   */
  // Maximum Subarray Sum (Kadane Algo)
  Integer maxSubArraySum(Integer[] arr) {
    int length = arr.length;
    int maxSum = arr[0];
    int sumEnding = arr[0];
    for (int i = 1; i < length; i++) {
      sumEnding = Math.max(sumEnding + arr[i], arr[i]);
      maxSum = Math.max(sumEnding, maxSum);
    }
    return maxSum;
  }

  /**
   * Example: 1 2 4 8 1 8 9 3 8 -> {1, 2} len=2 , {8,1,8,9} len=4, {3,8} len=2 -> Result = 4 1 2 3 4
   * 5 6 -> Result = 6
   *
   * @param arr array of integers
   * @return length of longest even odd sub-array
   */
  // Longest even odd subarray
  private static int longestEvenOddSubArray(int[] arr) {
    int count = 1;
    int max = 1;
    boolean even = (arr[0] & 1) == 0;
    int length = arr.length;

    for (int i = 1; i < length; i++) {
      boolean thisEven = (arr[i] & 1) == 0;
      // If both true then stop take max and reset count. If
      //      if (even) {
      //        if (thisEven) {
      //          max = Math.max(max, count);
      //          count = 1;
      //        } else {
      //          count++;
      //        }
      //      } else {
      //        if (thisEven) {
      //          count++;
      //        } else {
      //          max = Math.max(max, count);
      //          count = 1;
      //        }
      //      }
      if (even ^ thisEven) {
        count++;
      } else {
        max = Math.max(max, count);
        count = 1;
      }
      even = thisEven;
    }
    return count;
  }

  /**
   * @param arr
   * @return
   */
  //  Maximum Circular subarray sum (array sum - min sum subarray = max sum circular sub array)
  private static int maxCircularSubarraySum(int[] arr) {
    int length = arr.length;
    int sum = 0;
    // 1 -3 4 -2 5 4 -3 8
    return sum;
  }

  /**
   * Moore's Algorithm !!!! Does not give max occurring number !!!! If there exists a number which
   * exist more than n/2 times then it will be the one returned by this method. Returned value is
   * not guaranteed to appear more than n/2 times and neither does it have max occurrence. If
   * returned value does not appear more than n/2 times than no other value in the array will.
   *
   * @param arr array of candidates
   * @return potential candidate that may have majority votes
   */
  // Majority Element (Vote out and find potential candidate :  Moore's Voting Algorithm)
  private static int potentialMajority(int[] arr) {
    int count = 1;
    int res = 0;
    int length = arr.length;
    for (int i = 1; i < length; i++) {
      if (arr[res] == arr[i]) {
        count++;
      } else {
        count--;
      }
      if (count == 0) {
        res = i;
        count = 1;
      }
    }
    return arr[res];
  }

  /**
   * Given array of either 0 or 1. This methods prints minimum number of consecutive group flips
   * required to make array of unique element (Either 1's or 0's) Max diff between 1's and 0's group
   * is 1 If it starts with 0 and ends with 0. number of 0's groups is more than 1's groups
   * (vice-versa) If it starts with 0 and ends with 1. Number of 0's groups is = number of 1's
   * groups
   *
   * @param arr array of 0's or 1's
   */
  // minumum Consecutive flips (max diff in groups = 1)
  private static void minimumConsecutiveFlips(int[] arr) {
    int firstElement = arr[0];
    int len = arr.length;
    for (int i = 0; i < len; i++) {
      while (i < len && arr[i] == firstElement) {
        i++;
      }
      int start = i;
      while (i < len && arr[i] != firstElement) {
        i++;
      }
      if (i > start) {
        System.out.println("Flip from " + start + " to " + (i - 1) + " inclusive.");
      }
    }
  }

  /**
   * Get sum of max sum k length sub-array from array arr
   *
   * @param arr array of integers
   * @param k   length of sub-array
   * @return sum of max sum k length sub-array from array arr
   */
  //  Window sliding - find max sum k length sub array of an array of n elements ( n > k )
  private static int findMaxSumKLengthSubArray(int[] arr, int k) {
    int sum = 0;
    int len = arr.length;
    for (int i = 0; i < k; i++) {
      sum += arr[i];
    }
    int max = sum;
    for (int i = k; i < len; i++) {
      sum += arr[i] - arr[k - 1];
      max = Math.max(sum, max);
    }
    return max;
  }

  // Find sub-array in an array of positive integers such that sum of the sub array is equal to given sum.
  private static boolean checkIfSubArrayWithGivenSumExist(int[] arr, int s) {
    int sum = arr[0];
    int start = 0;
    int len = arr.length;
    for (int i = 1; i < len; i++) {
      if (sum == s) {
        return true;
      } else if (sum > s) {
        while (sum > s) {
          sum -= arr[start++];
        }
      } else {
        sum += arr[i];
      }
    }
    return false;
  }

  // Print first m n-bonacchi numbers. O(m)
  private static void printNBonacchiNumbers(int n, int m) {
    int sum = 0;
    Integer[] arr = new Integer[m];
    for (int i = 0; i < n - 1; i++) {
      arr[i] = 0;
    }
    arr[n - 1] = 1;
    arr[n] = 1;
    for (int i = n + 1; i < m; i++) {
      arr[i] = arr[i - 1] - arr[i - n - 1] + arr[i - 1];
    }
    printArray(arr);
  }

  //Efficiently perform queries on a fixed array (fixed by size and values). query(1, 4) -> sum of sub-array(1,4).
  private static void SumSumOfSubArrayUsingPrefixSum(Integer[] arr, Integer[] q) {
    int len = arr.length;
    Integer[] prefixSum = new Integer[len];
    prefixSum[0] = arr[0];
    for (int i = 1; i < len; i++) {
      prefixSum[i] = prefixSum[i - 1] + arr[i];
    }
    System.out.print("Prefix Sum Array: ");
    printArray(prefixSum);
    for (int i = 0; i < q.length - 1; i += 2) {
      int sumOfSubArray;
      if (q[i] == 0) {
        sumOfSubArray = prefixSum[q[i + 1]];
      } else {
        sumOfSubArray = prefixSum[q[i + 1]] - prefixSum[q[i] - 1];
      }
      System.out.println("Sum of sub-array [" + q[i] + "," + q[i + 1] + "] = " + sumOfSubArray);
    }
  }

  // Given array of integers. Find if it has an equibilibrium point.
  private static int checkIfArrayHasAnEquilibriumPoint(Integer[] arr) {
    int len = arr.length;
    int sum = 0;
    for (int i = 0; i < len; i++) {
      sum += arr[i];
    }
    int preSum = 0;
    for (int i = 0; i < len; i++) {
      if (arr[i] == sum - 2 * preSum) {
        return i;
      }
      preSum += arr[i];
    }
    return -1;
  }

  // Check if the subarray can be divided into 3 parts with equal sum
  private static boolean checkIfArrayCanBeDividedInto3SubArraysWithEqualSum(Integer[] arr) {
    //Logic here
    int sum = 0;
    int len = arr.length;
    for (int i = 0; i < len; i++) {
      sum += arr[i];
    }
    final int part;
    if (sum % 3 == 0) {
      part = sum / 3;
    } else {
      return false;
    }
    sum = 0;
    for (int i = 0; i < len; i++) {
      sum += arr[i];
      if (sum == part) {
        sum = 0;
      } else if (sum < part) {
        continue;
      } else {
        return false;
      }
    }
    return true;
  }

  private static int maxOccured(int l[], int r[], int n, int maxx) {
    int[] arr = new int[maxx + 2];
    for (int i = 0; i < n; i++) {
      arr[l[i]]++;
      arr[r[i] + 1]--;
    }
    int max = arr[0];
    int mi = 0;
    for (int i = 1; i < maxx + 1; i++) {
      arr[i] = arr[i] + arr[i - 1];
      if (arr[i] > max) {
        mi = i;
        max = arr[i];
      }
    }
    return mi;
  }

  public static void frequencyInArray(int[] arr) {
    int len = arr.length;
    for (int i = 0; i < len; i++) {
      if (arr[i] <= 0) {
        continue;
      }
      int elIndex = arr[i] - 1;
      if (arr[elIndex] <= 0) {
        arr[elIndex]--;
      } else {
        arr[i] = arr[elIndex];
        arr[elIndex] = -1;
        i--;
      }
    }
    for (int i = 0; i < len; i++) {
      if (arr[i] >= 0) {
        arr[i] = 0;
      } else {
        arr[i] = Math.abs(arr[i]);
      }
    }
  }

}
