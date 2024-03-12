package prob1259;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = sc.nextLine();
            if (s.equals("0")) {
                break;
            }
            int len = s.length();
            boolean f = false;
            for (int i = 0; i < len / 2; i++) {
                if (s.charAt(i) != s.charAt(len - 1 - i)) {
                    f = true;
                    break;
                }
            }
            if (f) {
                sb.append("no").append("\n");
            } else {
                sb.append("yes").append("\n");
            }
        }

        System.out.println(sb);
    }
}
