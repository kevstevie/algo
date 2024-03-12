package uteco.prob3186;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        int ltime = 0;
        int ktime = 0;
        int time = 0;
        boolean flag = false;
        boolean on = false;
        boolean everbe = false;
        boolean everon = false;

        int lasttime = 0;

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            time++;
            char c = s.charAt(i);
            if (c == '1') {
                everbe = true;
                flag = true;
                lasttime = time;
            } else {
                flag = false;
            }
            if (everbe) {
                if (!flag) {
                    ltime++;
                    ktime = 0;
                    if (ltime >= l && on) {
                        ltime = 0;
                        sb.append(time).append(System.lineSeparator());
                        on = false;
                    }
                } else {
                    ktime++;
                    ltime = 0;
                    if (ktime >= k) {
                        on = true;
                        everon = true;
                    }
                }
            }
        }
        if (on) {
            sb.append(lasttime + l);
        }


        System.out.println(everon ? sb : "NIKAD");
    }
}
