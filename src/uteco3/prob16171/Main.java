package uteco3.prob16171;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9') {
                continue;
            }
            sb.append(c);
        }

        String ans = br.readLine();

        System.out.println(sb.toString().contains(ans) ? 1 : 0);
    }

}
