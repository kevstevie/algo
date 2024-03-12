package prob9663;

import java.util.Scanner;

public class Main {

    static int ans = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[n + n];
        boolean[] diag2 = new boolean[n + n];

        recur(0, n, col, diag1, diag2);

        System.out.println(ans);
    }

    static void recur(int row, int n, boolean[] col, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            ans++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (col[i]) {
                continue;
            }
            if (diag1[row + i]) {
                continue;
            }
            if (diag2[row - i + n]) {
                continue;
            }
            col[i] = true;
            diag1[row + i] = true;
            diag2[row - i + n] = true;
            recur(row + 1, n, col, diag1, diag2);
            col[i] = false;
            diag1[row + i] = false;
            diag2[row - i + n] = false;
        }
    }
}
