package pgrmsub;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        List<Lecture> l = new ArrayList<>();
        for (String[] plan : plans) {
            l.add(new Lecture(plan[0], convert(plan[1]), Integer.parseInt(plan[2])));
        }
        l.sort(Comparator.comparing(lecture -> lecture.start));

        Deque<Lecture> q = new LinkedList<>();
        Stack<Lecture> w = new Stack<>();

        for (Lecture lecture : l) {
            q.offer(lecture);
        }

        List<String> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            Lecture now = q.poll();

            if (!q.isEmpty()) {
                Lecture peek = q.peek();
                int finish = plus(now.start, now.cost);
                if (finish > peek.start) {
                    w.push(now);
                    now.cost -= minus(peek.start, now.start);
                } else {
                    ans.add(now.name);
                    if (!w.isEmpty()) {
                        Lecture stack = w.peek();
                        stack.start = finish;
                        if (stack.start < peek.start) {
                            q.addFirst(w.pop());
                        }
                    }
                }
            } else {
                ans.add(now.name);
            }
        }
        while (!w.isEmpty()) {
            ans.add(w.pop().name);
        }

        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }

    static int plus(int a, int b) {
        int a1 = a % 100;
        return a + b + ((a1 + b) / 60) * 40;
    }
    static int minus(int a, int b) {
        int a2 = a % 100;
        int b2 = b % 100;

        if (b2 > a2) {
            return a - b - 40;
        } else {
            return a - b;
        }
    }

    private int convert(String s) {
        String[] split = s.split(":");
        return Integer.parseInt(split[0] + split[1]);
    }

    static class Lecture {
        String name;
        int start;
        int cost;

        public Lecture(String name, int start, int cost) {
            this.name = name;
            this.start = start;
            this.cost = cost;
        }
    }
}
