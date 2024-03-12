package prob11444;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long D = 1_000_000_007;
    static long[][] mat = new long[2][2];
    static {
        mat[0][0] = mat[0][1] = mat[1][0] = 1;
        mat[1][1] = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        long[][] ans = fibo(n);

        System.out.println(ans[1][0] % D);
    }

    private static long[][] fibo(long n) {
        if (n == 1 || n == 0) {
            return mat;
        }
        long[][] half = fibo(n / 2);

        half = multi(half, half);

        if (n % 2 == 1) {
            half = multi(half, mat);
        }

        return half;
    }
    static long[][] multi(long[][] a, long[][] b) {
        long[][] ans = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    ans[i][j] += (a[i][k] % D) * (b[k][j] % D) % D;
                }
            }
        }
        return ans;
    }

}
