package prob1918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        Stack<Character> s = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                sb.append(c);
            }
            if (c == '+' || c == '/' || c == '*' || c == '-') {
                while (!s.isEmpty() && prio(c) <= prio(s.peek())) {
                    sb.append(s.pop());
                }
                s.push(c);
            }
            if (c == '(') {
                s.push(c);
            }
            if (c == ')') {
                while(!s.isEmpty() && s.peek() != '('){
                    sb.append(s.pop());
                }
                s.pop();
            }

        }
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        System.out.println(sb);
    }

    static int prio(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '(':
            case ')':
                return 0;


        }
        return -1;
    }
}
