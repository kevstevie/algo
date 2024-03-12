package uteco7.prob1966;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<Item> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int e = Integer.parseInt(st.nextToken());
                q.offer(new Item(e, j));
                pq.offer(e);
            }

            order(q, m, sb, pq, 0);
        }
        System.out.println(sb);
    }

    private static void order(Queue<Item> q, int m, StringBuilder sb, PriorityQueue<Integer> pq, int cnt) {
        Item poll = q.poll();
        if (pq.peek() <= poll.num) {
            if (poll.order == m) {
                sb.append(cnt + 1).append(System.lineSeparator());
            } else {
                pq.poll();
                order(q, m, sb, pq, cnt + 1);
            }
        } else {
            q.offer(poll);
            order(q, m, sb, pq, cnt);
        }
    }
    static class Item {
        int num;
        int order;

        public Item(int num, int order) {
            this.num = num;
            this.order = order;
        }
    }
}
