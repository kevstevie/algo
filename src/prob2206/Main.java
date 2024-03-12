package prob2206;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String row = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
            }
        }

        Node node = new Node(0, 0, 0, false);
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(it -> it.dist));

        q.offer(node);
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        boolean[][][] visit = new boolean[n][m][2];
        visit[0][0][0] = true;
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.x == n - 1 && now.y == m - 1) {
                System.out.println(now.dist + 1);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int xx = now.x + dx[i];
                int yy = now.y + dy[i];

                if (xx < 0 || xx >= n || yy < 0 || yy >= m) {
                    continue;
                }

                if (now.b) {
                    if (visit[xx][yy][1]) {
                        continue;
                    }
                    if (map[xx][yy] == 1) continue;
                    q.offer(new Node(now.dist + 1, xx, yy, now.b));
                    visit[xx][yy][1] = true;
                } else {
                    if (visit[xx][yy][0]) continue;
                    if (map[xx][yy] == 0) {
                        q.offer(new Node(now.dist + 1, xx, yy, now.b));
                        visit[xx][yy][0] = true;
                    } else {
                        q.offer(new Node(now.dist + 1, xx, yy, true));
                        visit[xx][yy][0] = true;
                    }
                }

            }
        }
        System.out.println(-1);
    }

    static class Node {
        int dist;
        int x;
        int y;
        boolean b;

        public Node(final int dist, final int x, final int y, final boolean b) {
            this.dist = dist;
            this.x = x;
            this.y = y;
            this.b = b;
        }
    }
}
