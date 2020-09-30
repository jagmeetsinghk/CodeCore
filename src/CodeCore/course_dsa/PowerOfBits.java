package CodeCore.course_dsa;

import java.util.stream.IntStream;

import static java.lang.Math.log10;

public class PowerOfBits {
    public static void main(String[] args) {

        System.out.println("-------------------Find first Set Bit-------------------------------");
        System.out.println(findFirstSetBit(32));

        System.out.println("-------------------Find right most different bit-------------------");
        System.out.println(findRightmostDifferentBit(11, 9));

        System.out.println("-------------------Check Kth bit------------------------------------");
        System.out.println(checkKthBit(4, 0));

        System.out.println("-------------------Count set bits-----------------------------------");
        System.out.println(countSetBits(5));

        System.out.println("-------------------Count set bits till N----------------------------");
        System.out.println(countSetBitsTillN(17));

        System.out.println("-------------------Integer to binary--------------------------------");
        IntStream.range(0, 18).forEach(i -> System.out.print(Integer.toBinaryString(i) + " - "));
        System.out.println();

        System.out.println("-------------------Count bits flip----------------------------------");
        System.out.println(countBitsFlip(10, 20));

        System.out.println("-------------------Check if number is sparse------------------------");
        System.out.println(isSparse(5));

        System.out.println("-------------------Maximum consecutive set bits---------------------");
        System.out.println(maxConsecutiveOnes(14));

        System.out.println("--------------------------------------------------------------------");
        System.out.println(maxConsecutiveOnes(222));

        System.out.println("-------------------Binary to grey conversion------------------------");
        System.out.println(binaryToGrey(7));
        System.out.println(binaryToGrey(10));

        System.out.println("-------------------Swap odd and even bits---------------------------");
        System.out.println(swapOddAndEvenBits(23));
    }

    private static int swapOddAndEvenBits(int n) {
        int allEvenSet = -1431655766, allOddSet = 1431655765;
        int allEven = n & allEvenSet, allOdd = n & allOddSet;
        allEven >>>= 1;
        allOdd <<= 1;
        return allOdd ^ allEven;
    }

/*    private static int greyToBinary(int n){

    }*/

    private static int binaryToGrey(int n) {
        if (n == 0) return 0;
        int msb = (int) Math.floor(log10(n) / log10(2));
        int xorer = (int) Math.pow(2, msb) - 1;
        return (xorer & n) ^ (n >> 1) | (1 << msb);
    }

    private static int maxConsecutiveOnes(int x) {
        int maxCount = 0, count = 0;
        while (x > 0) {
            maxCount++;
            x = x >> 1;
        }
        return maxCount * 2;
    }

    private static boolean isSparse(int n) {
        return (n & (n << 1)) == 0;
    }

    private static int countBitsFlip(int a, int b) {
        int counter = 0;
        int XOR = a ^ b;
        while (XOR > 0) {
            XOR = XOR & (XOR - 1);
            counter++;
        }
        return counter;
    }

    private static int countSetBitsTillN(int n) {
        int counter = 0, rem = 0;
        int log2n = (int) (Math.floor(log10(n) / log10(2)) + 1);
        for (int i = 1; i <= log2n; i++) {
            int pow = (int) Math.pow(2, i);
            counter += ((n + 1) / pow * pow / 2);
            rem = (((n + 1) % pow) - (pow / 2));
            if (rem > 0) counter += rem;
        }
        return counter;
    }

    private static int countSetBits(int n) {
        int counter = 0;
        while (n > 0) {
            n = n & (n - 1);
            counter++;
        }
        return counter;
    }

    private static boolean checkKthBit(int n, int k) {
        return (n & (1 << k)) != 0;
    }

    private static int findRightmostDifferentBit(int a, int b) {
        int XOR = a ^ b;
        return (int) (log10(XOR & ~(XOR - 1)) / log10(2)) + 1;
    }

    private static int findFirstSetBit(int n) {
        return (int) (log10(n & ~(n - 1)) / log10(2)) + 1;
    }
}
