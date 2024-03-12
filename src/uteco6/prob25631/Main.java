package uteco6.prob25631;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            m.put(a, m.getOrDefault(a, 0) + 1);
        }

        int max = 0;

        for (int i : m.values()) {
            max = Math.max(i, max);
        }

        System.out.println(max);
    }

}

/*
4
2 2 3 3
 */
