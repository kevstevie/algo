package uteco6.prob19542;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        List<List<Integer>> l = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            l.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            l.get(x).add(y);
            l.get(y).add(x);
        }

        boolean[] visit = new boolean[n + 1];
//        Stack<Node> stack = new Stack<>();
//        stack.push(new Node(s, 0));
        visit[s] = true;

//        int ans = 0;
//        while (!stack.isEmpty()) {
//            Node now = stack.pop();
//            List<Integer> childs = l.get(now.pos);
//            int cnt = 0;
//            for (Integer i : childs) {
//                if (visit[i]) {
//                    continue;
//                }
//                stack.push(new Node(i, now.dist + 1));
//                visit[i] = true;
//                cnt++;
//            }
//            if (cnt == 0) {
//                ans += now.dist + 1;
//            }
//        }

        List<Node> leaf = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(null, s, 0));
        int[] distances = new int[n + 1];
        boolean[] v = new boolean[n + 1];

        int ans = 0;

        while (!stack.isEmpty()) {
            Node now = stack.pop();
            List<Integer> childs = l.get(now.pos);
            int cnt = 0;
            for (Integer i : childs) {
                if (visit[i]) {
                    continue;
                }
                stack.push(new Node(now, i, now.dis + 1));
                distances[i] = now.dis + 1;
                visit[i] = true;
                cnt++;
            }
            if (cnt == 0) {
                leaf.add(now);
            }
        }

        for (Node node : leaf) {
            int mind = Math.max(0, node.dis - d);
            ans += mind;
            if (node.dis <= d) {
                continue;
            }
            while (node.parent != null) {
                node = node.parent;
                if (node.pos == s) {
                    break;
                }
                if (v[node.pos]) {
                    ans -= Math.min(mind, node.dis);
                    break;
                }
                if (mind >= node.dis) {
                    v[node.pos] = true;
                }
            }
        }


        System.out.println(ans * 2);
    }

    static class Node {

        Node parent;
        int pos;
        int dis;

        public Node(Node parent, int pos, int dis) {
            this.parent = parent;
            this.pos = pos;
            this.dis = dis;
        }
    }
}
/*
7 1 1
1 2
2 3
2 4
3 5
5 6
4 7

8

6 1 1
1 2
2 3
3 4
4 5
3 6

6

8 1 1
1 2
1 3
3 4
4 5
5 6
3 7
7 8

8

14 1 1
1 2
1 3
1 7
3 4
3 5
5 6
7 8
8 9
7 10
10 11
11 12
7 13
13 14

14

8 1 2
1 2
2 3
1 4
4 5
5 6
4 7
4 8

2

9 1 2
1 2
2 3
1 4
4 5
5 6
4 7
4 8
8 9

2

9 1 3
1 2
2 3
3 4
4 5
5 6
4 7
4 8
8 9

4
 */
