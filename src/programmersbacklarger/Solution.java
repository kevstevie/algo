package programmersbacklarger;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Queue<Num> q = new LinkedList<>();
        q.offer(new Num(numbers[0], 1));

        for (int i = 1; i < numbers.length; i++) {
            while (!q.isEmpty() && q.peek().num < numbers[i]) {
                Num poll = q.poll();
                numbers[poll.idx] = numbers[i];
            }
            q.offer(new Num(numbers[i], i));
        }

        while (!q.isEmpty()) {
            Num poll = q.poll();
            answer[poll.idx] = -1;
        }
        return answer;
    }

    static class Num {
        int num;
        int idx;

        public Num(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
}
