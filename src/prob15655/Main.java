package prob15655;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);


        String[] s1 = sc.nextLine().split(" ");
        List<Integer> l = new ArrayList<>(Arrays.asList(s1)).stream()
                .map(Integer::parseInt)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        recur(0, l, new String[m], m, 0);

        System.out.println(ans);
    }

    static StringBuilder ans = new StringBuilder();

    static void recur(int idx, List<Integer> l, String[] k, int m, int c) {
        if (c == m) {
            ans.append(String.join(" ", k)).append(System.lineSeparator());
            return;
        }
        if (idx >= l.size()) return;
        String now = String.valueOf(l.get(idx));
        k[c] = now;
        recur(idx + 1, l, k, m, c + 1);
        recur(idx + 1, l, k, m, c);
    }
}
