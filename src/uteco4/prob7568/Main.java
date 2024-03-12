package uteco4.prob7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        List<int[]> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            l.add(new int[]{x, y});

        }

        for (int i = 0; i < n; i++) {
            int[] ints = l.get(i);
            sb.append(l.stream().filter(arr -> arr[0] > ints[0] && arr[1] > ints[1]).count() + 1).append(" ");
        }

        System.out.println(sb);
    }

}
