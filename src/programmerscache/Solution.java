package programmerscache;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        PriorityQueue<Cache> q = new PriorityQueue<>(Comparator.comparing((Cache cache) -> cache.time).reversed());

        for (String city : cities) {
            city = city.toLowerCase();
            String finalCity = city;
            if (q.stream()
                    .anyMatch(cache -> cache.s.equals(finalCity))) {
                answer++;
                q.remove(new Cache(0, city));
            } else {
                answer += 5;
            }
            for (Cache cache : q) {
                cache.time++;
            }
            q.offer(new Cache(0, city));

            if (q.size() > cacheSize) {
                q.poll();
            }
        }
        return answer;
    }

    static class Cache {
        int time;
        String s;

        public Cache(int time, String s) {
            this.time = time;
            this.s = s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cache cache = (Cache) o;
            return Objects.equals(s, cache.s);
        }

        @Override
        public int hashCode() {
            return Objects.hash(s);
        }
    }
}
