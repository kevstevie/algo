package pgrmcours;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {

        List<String> ans = new ArrayList<>();

        for (int i : course) {
            map = new HashMap<>();
            for (String order : orders) {
                char[] charArray = order.toCharArray();
                Arrays.sort(charArray);
                comb(charArray, i, "", 0, 0);
            }
            int max = 2;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                max = Math.max(max, entry.getValue());
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == max) {
                    ans.add(entry.getKey());
                }
            }
        }

        ans.sort(Comparator.naturalOrder());
        String[] answer = new String[ans.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }

    void comb(char[] order, int i, String str, int cnt, int idx) {
        if (cnt == i) {
            map.put(str, map.getOrDefault(str, 0) + 1);
            return;
        }
        if (idx >= order.length) {
            return;
        }
        comb(order, i, str, cnt, idx + 1);
        comb(order, i, str + order[idx], cnt + 1, idx + 1);
    }
}
