package uteco.prob27962;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String s = br.readLine();

        for (int i = 2; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                for (int k = j + 1; k < s.length() - i; k++) {
                    if (s.charAt(j) == s.charAt(k) && s.charAt(j + i) == s.charAt(k + i)) {
                        if (compare(j, k, i, s)) {
                            System.out.println("YES");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("NO");
    }

    static boolean compare(int j, int k, int i, String s) {
        int cnt = 0;
        for (int l = 0; l < i; l++) {
            if (s.charAt(j++) != s.charAt(k++)) {
                cnt++;
            }

        }
        return cnt == 1;
    }

}
