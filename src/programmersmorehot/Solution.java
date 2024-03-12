package programmersmorehot;

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i : scoville) {
            q.offer(i);
        }

        int answer = 0;

        while (q.size() >= 2) {
            Integer first = q.poll();
            Integer second = q.poll();

            q.offer(first + second * 2);
            answer++;
            if (q.peek() >= K) {
                return answer;
            }
        }

        return -1;
    }
}
