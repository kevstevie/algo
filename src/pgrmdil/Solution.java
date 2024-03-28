package pgrmdil;

import java.util.Arrays;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int INF = 50 * 10000 + 1;

        int[][] arr = new int[N + 1][N + 1];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], INF);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 0;
        }

        for (int[] ints : road) {
            int start = ints[0];
            int end = ints[1];
            int cost = ints[2];

            arr[start][end] = Math.min(arr[start][end], cost);
            arr[end][start] = arr[start][end];
        }

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                for (int k = 0; k < N + 1; k++) {
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (arr[1][i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}
