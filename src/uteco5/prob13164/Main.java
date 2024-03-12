package uteco5.prob13164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int j = Integer.parseInt(st.nextToken());
            arr[i] = j;
        }

        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            l.add(arr[i + 1] - arr[i]);
        }

        l.sort(Comparator.naturalOrder());

        int sum = l.stream()
                   .mapToInt(a -> a)
                   .limit(n - k)
                   .sum();

        System.out.println(sum);

    }

}
/*
6 3
1 2 8 9 15 16

1 6 1 6 1


5 3
1 3 5 6 10

2 2 1 4
 */
