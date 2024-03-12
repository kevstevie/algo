package prob9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            Stack<Character> st = new Stack<>();
            String s = br.readLine();
            boolean f = false;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '(') {
                    st.push(c);
                } else {
                    if (!st.isEmpty() && st.peek() == '(') {
                        st.pop();
                    } else {
                        st.push(c);
                    }
                }
            }
            sb.append(st.isEmpty() ? "YES" : "NO").append(System.lineSeparator());
        }
        System.out.println(sb);
    }

}
