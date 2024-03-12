package prob2293;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        int[] a = new int[n];
        int[] dp = new int[100_001];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(sc.nextLine());
        }

        for (int i : a) {
            dp[i] = 1;
        }



    }
}
