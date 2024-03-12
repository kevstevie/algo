package prob11866;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] s = scanner.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int c = 0;
        while (q.size() != 1) {
            if (++c == k) {
                sb.append(q.poll()).append(", ");
                c = 0;
            } else {
                q.offer(q.poll());
            }
        }
        sb.append(q.poll()).append(">");

        System.out.println(sb);
    }
}
