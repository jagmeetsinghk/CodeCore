package java.com.base.CodeCore.hackerrank.easy;

//https://www.hackerrank.com/challenges/cats-and-a-mouse/problem
public class CatsAndAMouse {
    static String catAndMouse(int x, int y, int z) {
        int a = Math.abs(x - z);
        int b = Math.abs(y - z);
        return a < b ? "Cat A" : b < a ? "Cat B" : "Mouse C";
    }

    public static void main(String[] args) {
        String result = catAndMouse(1, 3, 2);
        System.out.println(result);
    }
}
