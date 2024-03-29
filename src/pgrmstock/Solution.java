package pgrmstock;

import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Stock> s = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            int cur = prices[i];
            int time = prices.length - i - 1;

            while (!s.isEmpty() && s.peek().price > cur) {
                Stock pop = s.pop();
                answer[pop.idx] = pop.time - time;
            }
            s.push(new Stock(cur, i, time));
        }

        while (!s.isEmpty()) {
            Stock pop = s.pop();
            answer[pop.idx] = pop.time;
        }

        return answer;
    }

    static class Stock {
        int price;
        int idx;
        int time;

        public Stock(int price, int idx, int time) {
            this.price = price;
            this.idx = idx;
            this.time = time;
        }
    }
}
