package prob11047;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var nk = scanner.nextLine();
        String[] s = nk.split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        int[] ints = new int[n];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(scanner.nextLine());
        }

        int ans = 0;
        for (int i = ints.length - 1; i >= 0; i--) {
            int v = ints[i];
            if (v <= k) {
                int a = k / v;
                k -= a * v;
                ans += a;
            }
        }

        System.out.println(ans);
    }
}
