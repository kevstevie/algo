package prob2502;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
        a,b, a +b, a+ 2b, 2a + 3b, 3a + 5b, 5a + 8b
         */
        int[] dpa = new int[31];
        int[] dpb = new int[31];

        dpa[3] = 1;
        dpa[4] = 1;
        for (int i = 5; i <= 30; i++) {
            dpa[i] = dpa[i - 1] + dpa[i - 2];
        }

        dpb[3] = 1;
        dpb[4] = 2;
        for (int i = 5; i <= 30; i++) {
            dpb[i] = dpb[i - 1] + dpb[i - 2];
        }

        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int d = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        int maxa = Integer.MAX_VALUE / dpa[d];
        int maxb = Integer.MAX_VALUE / dpb[d];

        loop :
        for (int i = 1; i <= maxa; i++) {
            for (int j = 1; j <= maxb; j++) {
                if (i * dpa[d] + j * dpb[d] == k) {
                    System.out.println(i);
                    System.out.println(j);
                    break loop;
                }
            }
        }

    }
}
