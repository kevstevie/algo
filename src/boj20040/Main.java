package boj20040;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());


            if (find(start) == find(end)) {
                System.out.println(i + 1);
                return;
            }
            union(start, end);
        }

        System.out.println(0);
    }

    static void union(int start, int end) {
        start = find(start);
        end = find(end);
        if (start > end) {
            arr[start] = end;
        } else {
            arr[end] = start;
        }
    }

    static int find(int start) {
        if (arr[start] == start) {
            return start;
        }
        return find(arr[start]);
    }
}

/*
6 6
0 1
1 2
2 3
5 4
0 4
0 5

4 3
0 1
2 0
2 3
 */
