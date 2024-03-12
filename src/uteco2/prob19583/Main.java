package uteco2.prob19583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = parseTime(st.nextToken());
        int end = parseTime(st.nextToken());
        int end2 = parseTime(st.nextToken());

        int ans = 0;
        Map<String, Integer> m = new HashMap<>();
        List<String> l = new ArrayList<>();
        String line = "";
        while ((line = br.readLine()) != null) {
            l.add(line);
        }

        for (String s : l) {
            String[] s1 = s.split(" ");
            String name = s1[1];
            int time = parseTime(s1[0]);
            if (time <= start) {
                m.put(name, time);
            } else if(time <= end2 && time >= end) {
                if (m.containsKey(name)) {
                    ans++;
                    m.remove(name);
                }
            }
        }

        System.out.println(ans);
    }

    private static int parseTime(String s) {
        return Integer.parseInt(String.join("", s.split(":")));
    }

}
