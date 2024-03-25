package pgrmtrasnform;

import java.util.Stack;

class Solution {
    public String solution(String p) {
        return recur(p);
    }

    public String recur(String s) {
        if (s.isEmpty()) {
            return "";
        }
        int l = 0;
        int r = 0;
        String u = "";
        String v = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            } else {
                r++;
            }
            if (l == r) {
                u = s.substring(0, i + 1);
                v = s.substring(i + 1);
                break;
            }
        }
        if (check(u)) {
            return u + recur(v);
        } else {
            return "(" + recur(v) + ")" + reverse(u.substring(1, u.length() - 1));
        }

    }

    private boolean check(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (st.empty()) {
                st.push(c);
            } else {
                if (c == '(') {
                    st.push(c);
                } else {
                    if (st.peek() == '(') {
                        st.pop();
                    }
                }
            }
        }

        return st.empty();
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                sb.append('(');
            } else {
                sb.append(')');
            }
        }
        return sb.toString();
    }
}
