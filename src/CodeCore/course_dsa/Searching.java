package CodeCore.course_dsa;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Searching {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(searchInSortedArray(arr, 1));
        System.out.println(searchInSortedArray(arr, 1, 0, arr.length - 1));
        System.out.println(searchFirstOccurenceInSortedArray(arr, 1));
        System.out.println(searchLastOccurenceInSortedArray(arr, 1));
        System.out.println(countOccurenceInSortedArray(arr, 1));
        System.out.println(count1sInSortedBinaryArray(new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 1}));
        System.out.println(squareRootUsingBinarySearch(10));

        long start = System.currentTimeMillis();
        Random random = new Random();
        int[] infArray = IntStream.generate(() -> random.nextInt(Integer.MAX_VALUE)).limit(999999).toArray();
        int key = random.nextInt(1000000);
        infArray[1] = key;
        Arrays.sort(infArray);
        System.out.println(((System.currentTimeMillis() - start) / 1000.0) + " seconds to sort 1000000 records");

        System.out.println(searchInInfiniteSortedArray(infArray, key));
    }

    private static int searchInInfiniteSortedArray(int[] arr, int key) {
        int i = 1;
        while (arr[i] < key) {
            i *= 2;
        }
        int start = i/2, end = i, mid = (start + end) / 2;
        while (start <= end) {
            int el = arr[mid];
            if (el < key) {
                start = mid +1;
            } else if (el > key) {
                end = mid - 1;
            } else {
                return mid;
            }
            mid = (start + end) / 2;
        }
        return -1;
    }

    private static int squareRootUsingBinarySearch(int n) {
        int start = 1, end = n / 2, mid = (start + end) / 2, ans = -1;
        while (start <= end) {
            int sq = mid * mid;
            if (sq == n) {
                return mid;
            } else if (sq < n) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        return ans;
    }

    private static int count1sInSortedBinaryArray(int[] arr) {
        int start = 0, end = arr.length - 1, mid = (start + end) / 2;
        int index = -1;
        while (start <= end) {
            int element = arr[mid];
            if (element == 0) {
                start = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] == 0) {
                    index = mid;
                    break;
                } else {
                    index = mid;
                    end = mid - 1;
                }
            }
            mid = (start + end) / 2;
        }
        return arr.length - index;
    }

    private static int countOccurenceInSortedArray(int[] arr, int key) {
        int first = searchFirstOccurenceInSortedArray(arr, key);
        return first == -1 ? first : searchLastOccurenceInSortedArray(arr, key) - first + 1;
    }

    private static int searchLastOccurenceInSortedArray(int[] arr, int key) {
        int start = 0, end = arr.length - 1, mid = (start + end) / 2;
        int index = -1;
        while (start <= end) {
            int element = arr[mid];
            if (element < key) {
                start = mid + 1;
            } else if (element > key) {
                end = mid - 1;
            } else {
                if (mid == arr.length - 1 || arr[mid + 1] != element) {
                    return mid;
                } else {
                    index = mid;
                    start = mid + 1;
                }
            }
            mid = (start + end) / 2;
        }
        return index;
    }

    private static int searchFirstOccurenceInSortedArray(int[] arr, int key) {
        int start = 0, end = arr.length - 1, mid = (start + end) / 2;
        int index = -1;
        while (start <= end) {
            int element = arr[mid];
            if (element < key) {
                start = mid + 1;
            } else if (element > key) {
                end = mid - 1;
            } else {
                if (mid == 0 || arr[mid - 1] != element) {
                    return mid;
                } else {
                    index = mid;
                    end = mid - 1;
                }
            }
            mid = (start + end) / 2;
        }
        return index;
    }

    private static int searchInSortedArray(int[] arr, int key) {
        int start = 0, end = arr.length - 1, mid = (start + end) / 2;
        while (start <= end) {
            int element = arr[mid];
            if (element == key) {
                return mid;
            } else if (element < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        return -1;
    }

    private static int searchInSortedArray(int[] arr, int key, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        int element = arr[mid];
        if (element == key) {
            return mid;
        } else if (element < key) {
            return searchInSortedArray(arr, key, mid + 1, end);
        } else {
            return searchInSortedArray(arr, key, start, mid - 1);
        }
    }
}
