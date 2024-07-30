package pgrmbfs;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(0, 0, 1));

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        boolean[][] v = new boolean[maps.length][maps[0].length];
        v[0][0] = true;

        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 4; i++) {
                int xx = now.x + dx[i];
                int yy = now.y + dy[i];

                if (xx < 0 || xx >= maps.length || yy < 0 || yy >= maps[0].length) {
                    continue;
                }
                if (v[xx][yy]) continue;
                if (maps[xx][yy] == 0) {
                    continue;
                }
                if (xx == maps.length - 1 && yy == maps[0].length - 1) {
                    ans = Math.min(ans, now.dis + 1);
                }
                q.offer(new Node(xx, yy, now.dis + 1));
                v[xx][yy] = true;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    static class Node {
        int x;
        int y;
        int dis;

        public Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}
