package pgrmelev;

class Solution {
    public int solution(int storey) {
        return recur(storey);
    }

    int recur(int i) {
        if (i == 0) {
            return 0;
        }
        int num = i % 10;
        if (num < 5) {
            return num + recur(i / 10);
        } else if (num > 5) {
            return 10 - num + recur(i / 10 + 1);
        } else {
            if (i % 100 >= 50) {
                return 10 - num + recur(i / 10 + 1);
            } else {
                return num + recur(i / 10);
            }
        }
    }
}
