package prob2217;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            l.add(Integer.parseInt(sc.nextLine()));
        }

        l.sort(Comparator.reverseOrder());

        int ans = l.get(0);
        int k = 1;
        for (int i = 1; i < n; i++) {
            int c = l.get(i);
            ans = Math.max(c * ++k, ans);
        }
        System.out.println(ans);
    }
}
