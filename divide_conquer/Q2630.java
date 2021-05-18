package divide_conquer;

// https://www.acmicpc.net/problem/2630
// 색종이 만들기

import java.io.*;
import java.util.*;

public class Q2630 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] answer = solution(N, arr);
        bw.write(String.format("%d\n%d", answer[0], answer[1]));
        bw.close();
    }

    static int[] solution(int N, int[][] arr) {
        int[] answer = {0, 0};
        dfs(arr, 0, 0, N, answer);
        return answer;
    }

    private static void dfs(int[][] arr, int col, int row, int size, int[] answer) {
        boolean check = true;
        int color = arr[row][col];
        for (int i = row, ii = row + size; i < ii; i++) {
            for (int j = col, jj = col + size; j < jj; j++) {
                if (color != arr[i][j]) {
                    check = false;
                    i = ii;
                    break;
                }
            }
        }

        if (check) answer[color]++;
        else {
            final int DIVIDE = 2, SIZE = size / 2;
            for (int i = 0; i < DIVIDE; i++) {
                for (int j = 0; j < DIVIDE; j++) {
                    dfs(arr, col + (SIZE * i), row + (SIZE * j), SIZE, answer);
                }
            }
        }
    }
}
