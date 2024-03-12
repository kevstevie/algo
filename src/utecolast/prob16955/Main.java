package utecolast.prob16955;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] a = new char[10][10];
        for (int i = 0; i < 10; i++) {
            String s = br.readLine();
            for (int j = 0; j < 10; j++) {
                a[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 10; j++) {
                int xcnt = 0;
                int ocnt = 0;
                for (int k = 0; k < 5; k++) {
                    if (a[i + k][j] == 'X') {
                        xcnt++;
                    }
                    if (a[i + k][j] == 'O') {
                        ocnt++;
                    }
                }
                if (xcnt == 4 && ocnt == 0) {
                    System.out.println(1);
                    return;
                }
            }
        }

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 6; j++) {
                int xcnt = 0;
                int ocnt = 0;
                for (int k = 0; k < 5; k++) {
                    if (a[i][j + k] == 'X') {
                        xcnt++;
                    }
                    if (a[i][j + k] == 'O') {
                        ocnt++;
                    }
                }
                if (xcnt == 4 && ocnt == 0) {
                    System.out.println(1);
                    return;
                }
            }
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                int xcnt = 0;
                int ocnt = 0;
                for (int k = 0; k < 5; k++) {

                    if (a[i + k][j + k] == 'X') {
                        xcnt++;
                    }
                    if (a[i + k][j + k] == 'O') {
                        ocnt++;
                    }
                }
                if (xcnt == 4 && ocnt == 0) {
                    System.out.println(1);
                    return;
                }
            }
        }

        for (int i = 4; i < 10; i++) {

            for (int j = 0; j < 6; j++) {
                int xcnt = 0;
                int ocnt = 0;
                for (int k = 0; k < 5; k++) {
                    if (a[i - k][j + k] == 'X') {
                        xcnt++;
                    }
                    if (a[i - k][j + k] == 'O') {
                        ocnt++;
                    }
                }
                if (xcnt == 4 && ocnt == 0) {
                    System.out.println(1);
                    return;
                }
            }
        }

        System.out.println(0);
    }
}
/*
XX........
.X...OOOO.
..X.......
...O......
....X.....
..........
..........
..........
..........
..........

XXOXX.....
.X...OOOO.
..X.......
...O......
....X.....
..........
..........
..........
..........
..........

XX.XX.....
.X...OOOO.
..X.......
...O......
....X.....
..........
..........
..........
..........
..........

XXOXX....X
.X...OOOX.
..X....X..
...O..X...
....O.....
.........O
...X..O..X
..O......X
.X......XX
XXOXXOOXXX
 */
