package pgrmq;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        for (int i : queue1) {
            q1.offer((long) i);
            sum1 += i;
        }
        for (int i : queue2) {
            q2.offer((long) i);
            sum2 += i;
        }

        int len = queue1.length + queue2.length;
        len *= 3;
        int cnt = 0;
        while (len > 0) {
            len--;
            if (sum1 > sum2) {
                Long poll = q1.poll();
                q2.offer(poll);
                sum1 -= poll;
                sum2 += poll;
            } else if (sum2 > sum1) {
                Long poll = q2.poll();
                q1.offer(poll);
                sum2 -= poll;
                sum1 += poll;
            } else {
                return cnt;
            }
            cnt++;
        }
        return -1;
    }
}
