package prob1202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

        List<Item> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            l.add(new Item(m, v));
        }

        List<Integer> bags = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int c = Integer.parseInt(br.readLine());
            bags.add(c);
        }

        l.sort(Comparator.comparing(item -> item.m));

        bags.sort(Comparator.naturalOrder());
        long sum = 0;

        int idx = 0;
        for (Integer bag : bags) {
            for (int i = idx; i < l.size(); i++) {
                Item item = l.get(i);
                if (item.m > bag) {
                    break;
                }
                q.offer(item.v);
                idx++;
            }

            if (!q.isEmpty()) {
                sum += q.poll();
            }
        }

        System.out.println(sum);
    }

    static class Item {
        int m;
        int v;

        public Item(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
}
