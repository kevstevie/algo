package prob1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int r;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        char[][] m = new char[r][c];
        boolean[][] v2 = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                m[i][j] = s.charAt(j);
            }
        }

        Deque<Node> q = new LinkedList<>();

        q.push(new Node(0, 0, 1));

        recur(new LinkedList<>(), new boolean[30], new boolean[r][c], m);

        System.out.println(max);
    }
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int max = 0;
    static void recur(Deque<Node> q, boolean[] v1, boolean[][] v2, char[][] m) {
        if (q.isEmpty()) return;
        Node now = q.pop();
        for (int i = 0; i < 4; i++) {
            int x = now.x + dx[i];
            int y = now.y = dy[i];
            if (x < 0 || x >= r || y < 0 || y >= c || v2[x][y]) continue;
            v2[x][y] = true;
            q.push(new Node(x, y, now.dist + 1));
        }
    }
    static class Node {
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
