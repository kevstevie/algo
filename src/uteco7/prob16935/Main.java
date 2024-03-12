package uteco7.prob16935;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
             st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < r; i++) {
            int operation = Integer.parseInt(st.nextToken());
            arr = op(operation, arr);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    static int n;
    static int m;
    static int r;

    static int[][] op(int operation, int[][] arr) {
        int[][] ints = new int[arr.length][arr[0].length];
        int halfn = arr.length / 2;
        int halfm = arr[0].length / 2;
        switch (operation) {
            case 1:
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[0].length; j++) {
                        ints[arr.length - i - 1][j] = arr[i][j];
                    }
                }
                break;
            case 2:
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[0].length; j++) {
                        ints[i][arr[0].length - j - 1] = arr[i][j];
                    }
                }
                break;
            case 3:
                ints = new int[arr[0].length][arr.length];
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[0].length; j++) {
                        ints[j][arr.length - i - 1] = arr[i][j];
                    }
                }
                break;
            case 4:
                ints = new int[arr[0].length][arr.length];
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[0].length; j++) {
                        ints[arr[0].length - j - 1 ][i] = arr[i][j];
                    }
                }
                break;
            case 5:
                int[][] i1 = new int[halfn][halfm];
                int[][] i2 = new int[halfn][halfm];
                int[][] i3 = new int[halfn][halfm];
                int[][] i4 = new int[halfn][halfm];
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[0].length; j++) {
                        if (i >= halfn) {
                            if (j >= halfm) {
                                i3[i % halfn][j % halfm] = arr[i][j];
                            } else {
                                i4[i % halfn][j % halfm] = arr[i][j];
                            }
                        } else {
                            if (j >= halfm) {
                                i2[ i % halfn][j % halfm] = arr[i][j];
                            } else {
                                i1[i % halfn][j % halfm] = arr[i][j];
                            }
                        }
                    }
                }
                ints = new int[arr.length][arr[0].length];
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[0].length; j++) {
                        if (i >= halfn) {
                            if (j >= halfm) {
                                ints[i][j] = i2[i % halfn][j % halfm];
                            } else {
                                ints[i][j] = i3[i % halfn][j % halfm];
                            }
                        } else {
                            if (j >=halfm) {
                                ints[i][j] = i1[i % halfn][j % halfm];
                            } else {
                                ints[i][j] = i4[i % halfn][j % halfm];
                            }
                        }
                    }
                }

                break;
            case 6:
                i1 = new int[halfn][halfm];
                i2 = new int[halfn][halfm];
                i3 = new int[halfn][halfm];
                i4 = new int[halfn][halfm];
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[0].length; j++) {
                        if (i >= halfn) {
                            if (j >= halfm) {
                                i3[i % halfn][j % halfm] = arr[i][j];
                            } else {
                                i4[i % halfn][j % halfm] = arr[i][j];
                            }
                        } else {
                            if (j >= halfm) {
                                i2[ i % halfn][j % halfm] = arr[i][j];
                            } else {
                                i1[i % halfn][j % halfm] = arr[i][j];
                            }
                        }
                    }
                }
                ints = new int[arr.length][arr[0].length];
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[0].length; j++) {
                        if (i >= halfn) {
                            if (j >= halfm) {
                                ints[i][j] = i4[i % halfn][j % halfm];
                            } else {
                                ints[i][j] = i1[i % halfn][j % halfm];
                            }
                        } else {
                            if (j >=halfm) {
                                ints[i][j] = i3[i % halfn][j % halfm];
                            } else {
                                ints[i][j] = i2[i % halfn][j % halfm];
                            }
                        }
                    }
                }


                break;
        }

        return ints;
    }
}
