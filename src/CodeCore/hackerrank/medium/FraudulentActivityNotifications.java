package CodeCore.hackerrank.medium;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem
public class FraudulentActivityNotifications {

    static int activityNotifications(int[] expenditure, int d) {
        int notificationCount = 0;
        int[] data = new int[201];
        for (int i = 0; i < d; i++) data[expenditure[i]]++;

        for (int i = d, len = expenditure.length; i < len; i++) {
            double median = getMedian(data, d);

            if (expenditure[i] >= (median + median)) {
                notificationCount++;
            }
            data[expenditure[i - d]]--;
            data[expenditure[i]]++;
        }
        return notificationCount;
    }

    private static double getMedian(int[] data, int d) {
        if ((d & 1) == 0) {
            Integer m1 = null, m2 = null;
            int count = 0;
            for (int i = 0; i < 201; i++) {
                count += data[i];
                if (m1 == null && count >= d / 2) m1 = i;
                if (m2 == null && count >= d / 2 + 1) {
                    m2 = i;
                    break;
                }
            }
            return (m1 + m2) / 2.0;
        } else {
            int count = 0;
            for (int i = 0; i < 201; i++) {
                count += data[i];
                if (count > d / 2) return i;
            }
        }
        return 0;
    }

// Gives Timeout Exception
//    static int activityNotifications(int[] expenditure, int d) {
//        int len = expenditure.length;
//        int[] trailing = new int[d];
//        for (int i = 0; i < d && i < len; i++) {
//            trailing[i] = expenditure[i];
//        }
//        Arrays.sort(trailing);
//        int count = 0;
//        for (int i = d; i < len; i++) {
//
//            double median = getMedian(trailing, d);
//            if (expenditure[i] >= 2 * median) {
//                count++;
//            }
//
//            removeFromTrailing(trailing, expenditure[i - d], d);
//            addToTrailing(trailing, expenditure[i], d);
//        }
//        return count;
//    }
//
//    private static void removeFromTrailing(int[] trailing, int key, int d) {
//        int index = Arrays.binarySearch(trailing, key);
//        for (int i = index; i < d - 1; i++) {
//            trailing[i] = trailing[i + 1];
//        }
//    }
//
//    private static void addToTrailing(int[] trailing, int val, int d) {
//        int index = Arrays.binarySearch(trailing, val);
//        if (index < 0) index = (index + 1) * -1;
//        else index += 1;
//        if (index >= d) {
//            trailing[d - 1] = val;
//            return;
//        }
//        for (int i = index + 1; i < d; i++) {
//            trailing[i] = trailing[i - 1];
//        }
//        trailing[index] = val;
//    }
//
//    private static double getMedian(int[] a, int d) {
//        if ((d & 1) == 0) {
//            return (a[d / 2 - 1] + a[d / 2]) / 2.0;
//        } else {
//            return a[d / 2];
//        }
//    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
