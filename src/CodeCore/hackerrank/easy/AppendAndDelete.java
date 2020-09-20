package CodeCore.hackerrank.easy;

//https://www.hackerrank.com/challenges/append-and-delete/problem
public class AppendAndDelete {
    static String appendAndDelete(String s, String t, int k) {
        int chances = 0, i = 0, sl = s.length(), tl = t.length();
        if (k >= sl + tl) return "Yes";
        boolean same = true;
        while (same)
            try {
                if (s.charAt(i) == t.charAt(i)) i++;
                else same = false;
            } catch (IndexOutOfBoundsException e) {
                same = false;
            }
        chances = sl - i;
        chances += tl - i;
        return (chances == k) || ((k > chances) && ((k - chances) % 2 == 0)) ? "Yes" : "No";
    }

    public static void main(String[] args) {
//        String s = "asdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv";
//        String t = "bsdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv";
        String s = "qwerasdf";
        String t = "qwerasdf";
        String res = appendAndDelete(s, t, 6);
        System.out.println(res);
    }
}
