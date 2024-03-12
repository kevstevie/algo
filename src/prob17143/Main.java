//package prob17143;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    static int r, c, m;
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        r = Integer.parseInt(st.nextToken());
//        c = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//
//
//        Map<Position, Shark> map = new HashMap<>();
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine());
//
//            int x = Integer.parseInt(st.nextToken());
//            int y = Integer.parseInt(st.nextToken());
//            int s = Integer.parseInt(st.nextToken());
//            int d = Integer.parseInt(st.nextToken());
//            int z = Integer.parseInt(st.nextToken());
//
//            map.merge(new Position(x, y), new Shark(s, d, z), (Shark::bigger));
//        }
//
//        int cnt = 0;
//
//        for (int i = 1; i <= r; i++) {
//            l.sort(Comparator.comparing(shark -> shark.y));
//            for (Shark shark : l) {
//                if (shark.x == i) {
//                    l.remove(shark);
//                    cnt += shark.z;
//                    break;
//                }
//            }
//            for (Shark shark : l) {
//                shark.move(shark.s);
//            }
//        }
//
//        System.out.println(cnt);
//    }
//
//    static class Position {
//        int x;
//        int y;
//
//        public Position(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    static class Shark {
//        int s;
//        int d;
//        int z;
//
//        public Shark(int s, int d, int z) {
//            this.s = s;
//            this.d = d;
//            this.z = z;
//        }
//
//        public void move(int energy) {
//            if (energy == 0) return;
//            if (this.d == 1) {
//
//            } else if (this.d == 2) {
//
//            } else if (this.d == 3) {
//
//            } else {
//
//            }
//        }
//
//        public Shark bigger(Shark shark2) {
//            if (this.z > shark2.z) {
//                return this;
//            }
//            return shark2;
//        }
//    }
//}
