package prob2042;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] arr = new long[n + 1];

        sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Seg seg = new Seg(n);

        seg.init(arr, 1, 1, n);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());

            int com = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (com == 1) {
                arr[start] = end;
                seg.update(start, end);
            } else {
                seg.get(start, end);
            }
        }

        System.out.println(sb);
    }

    static class Seg {
        long[] tree;
        int size;

        public Seg(int size) {
            int h = (int) Math.ceil(Math.log(size) / Math.log(2));

            this.size = (int) Math.pow(2, h + 1);

            tree = new long[this.size];
        }

        public long init(long[] arr, int node, int start, int end) {

            if (start == end) {
                return tree[node] = arr[start];
            }
            return tree[node] = init(arr, node * 2, start, (start + end) / 2)
                    + init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
        }

        public void update(int start, int end) {

        }

        public void get(int start, int end) {

        }
    }
}
