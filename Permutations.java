package backtracking;

public class Permutations {
    public static void main(String[] args) {
        permutations("abcd", 0, 3);
        System.out.println();
        permutationsEff("abcd", 0, 3);
    }

    public static void permutations(String s, int l, int r) {
        if (l == r) {
            if (!s.contains("ab"))
                System.out.print(s + " ");
            return;
        }
        for (int i = l; i <= r; i++) {
            s = new String(swap(s, l, i));
            permutations(s, l + 1, r);
            s = new String(swap(s, i, l));
        }
    }

    public static char[] swap(String s, int i, int j) {
        char[] c = s.toCharArray();
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        return c;
    }

    public static void permutationsEff(String s, int l, int r) {
        if (l == r) {
            System.out.print(s + " ");
            return;
        }
        for (int i = l; i <= r; i++) {
            if (isSafe(s, l, i, r)) {
                s = new String(swap(s, l, i));
                permutationsEff(s, l + 1, r);
                s = new String(swap(s, l, i));
            }
        }
    }

    public static boolean isSafe(String s, int l, int i, int r) {
        if (l != 0 && s.charAt(l - 1) == 'a' && s.charAt(i) == 'b')
            return false;
        if (r == l + 1 && s.charAt(l) == 'b' && s.charAt(i) == 'a')
            return false;
        return true;
    }
}
