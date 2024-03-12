package prob1931;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<int[]> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split(" ");
            a.add(new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])});
        }
        a.sort(Comparator.comparing((int[] arr) -> arr[1]).thenComparing(arr -> arr[0]));
        int end = 0;
        int ans = 0;
        for (final int[] ints : a) {
            if (ints[0] >= end) {
                end = ints[1];
                ans++;
            }

        }
        System.out.println(ans);

    }
}
