package utecolast.prob27522;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] score = new int[]{10, 8, 6, 5, 4, 3, 2, 1, 0};
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String time = st.nextToken();
            String team = st.nextToken();

            l.add(new Player(time, team));


        }
        int b = 0;
        int r = 0;

        l.sort(Comparator.comparing(player -> player.time));

        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).team.equals("B")) {
                b += score[i];
                continue;
            }
            r += score[i];
        }

        System.out.println(b > r ? "Blue" : "Red");

    }

    static class Player {
        String time;
        String team;

        public Player(String time, String team) {
            this.time = time;
            this.team = team;
        }
    }
}
