package pgmopen;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {


    public String[] solution(String[] record) {
        Map<String, String> m = new HashMap<>();
        Queue<Info> q = new LinkedList<>();
        for (String s : record) {
            String[] s1 = s.split(" ");
            if (!s1[0].equals("Leave")) {
                m.put(s1[1], s1[2]);
            }
            if (s1[0].equals("Change")) {
                continue;
            }
            q.offer(new Info(s1[1], s1[0]));
        }
        String[] answer = new String[q.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = q.poll().toText(m);
        }
        return answer;
    }

    static class Info {
        String uid;
        String el;

        public Info(String uid, String el) {
            this.uid = uid;
            this.el = el;
        }

        public String toText(Map<String, String> m) {
            return m.get(uid) + (el.equals("Enter") ? "님이 들어왔습니다." : "님이 나갔습니다.");
        }
    }

}
