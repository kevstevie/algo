package prob1068;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] s = sc.nextLine().split(" ");
        int r = sc.nextInt();

        List<List<Integer>> l = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            l.add(new ArrayList<>());
        }
        int root = 0;
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(s[i]);
            if (target == -1) {
                root = i;
            } else {
                if (i != r) {
                    l.get(target).add(i);
                }
            }
        }
        if (r == root) {
            System.out.println(0);
            return;
        }
        l.get(r).clear();

        recur(root, l);

        System.out.println(ans);

    }

    static int ans = 0;

    static void recur(int root, List<List<Integer>> l) {
        if (l.get(root).isEmpty()) {
            ans++;
            return;
        }
        for (final Integer integer : l.get(root)) {
            recur(integer, l);
        }
    }
}
