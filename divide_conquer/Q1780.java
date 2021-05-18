package divide_conquer;

// https://www.acmicpc.net/problem/1780
// 종이의 개수

import java.io.*;
import java.util.*;

public class Q1780 {
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
        bw.write(String.format("%d\n%d\n%d", answer[0], answer[1], answer[2]));
        bw.close();
    }

    static int[] solution(int N, int[][] arr) {
        int[] answer = {0, 0, 0};
        dfs(arr, 0, 0, N, answer);
        return answer;
    }

    private static void dfs(int[][] arr, int row, int col, int size, int[] answer) {
        boolean check = true;
        int type = arr[row][col];

        for (int i = row, ii = row + size; i < ii; i++) {
            for (int j = col, jj = col + size; j < jj; j++) {
                if (arr[i][j] != type) {
                    check = false;
                    i = ii;
                    break;
                }
            }
        }

        if (check) answer[type + 1]++;
        else {
            final int DIVIDE = 3, SIZE = size / DIVIDE;
            for (int i = 0; i < size; i += SIZE) {
                for (int j = 0; j < size; j += SIZE) {
                    dfs(arr, row + i, col + j, SIZE, answer);
                }
            }
        }
    }
}
