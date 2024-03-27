package pgrmstick;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(String name) {
        int answer = 0;
        char[] ch = name.toCharArray();
        int dis = Integer.MAX_VALUE;
        long v = 0;

        for (char c : ch) {
            int i = c - 'A';
            if (i <= 13) {
                answer += i;
            } else {
                answer += 26 - i;
            }
        }

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != 'A') {
                v = v | 1 << i;
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0, 1));
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.cnt > ch.length + 2) {
                continue;
            }
            if ((now.bit & v) == v) {
                dis = Math.min(dis, now.dis);
                continue;
            }

            int prev = now.pos - 1;
            int next = now.pos + 1;

            if (prev < 0) {
                prev = ch.length - 1;
            }
            if (next >= ch.length) {
                next = 0;
            }
            q.offer(new Node(next, now.dis + 1, now.cnt + 1, now.bit | (1 << next)));
            q.offer(new Node(prev, now.dis + 1, now.cnt + 1, now.bit | (1 << prev)));
        }

        answer += dis;

        return answer;
    }

    static class Node {
        int pos;
        int dis;
        int cnt;
        long bit;

        public Node(int pos, int dis, int cnt, long bit) {
            this.pos = pos;
            this.dis = dis;
            this.cnt = cnt;
            this.bit = bit;
        }
    }
}
