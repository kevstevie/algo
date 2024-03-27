package pgrmlast;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> s = new HashSet<>();
        s.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            int order = i % n + 1;
            char last = words[i - 1].charAt(words[i - 1].length() - 1);
            char start = words[i].charAt(0);
            if (last != start) {
                return new int[]{order, i / n + 1};
            }
            if (s.contains(words[i])) {
                return new int[]{order, i / n + 1};
            } else {
                s.add(words[i]);
            }
        }

        return new int[]{0, 0};
    }
}
