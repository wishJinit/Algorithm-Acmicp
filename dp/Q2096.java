package dp;

// https://www.acmicpc.net/problem/2096
// 내려가기

import java.io.*;
import java.util.*;

public class Q2096 {
    final static int NUM_CNT = 3;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][NUM_CNT];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < NUM_CNT; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int n : solution(N, arr)) sb.append(n).append(" ");
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static int[] solution(int N, int[][] arr) {
        int[] answer = {Integer.MIN_VALUE, Integer.MAX_VALUE};
        int[][] minDp = new int[N + 1][NUM_CNT], maxDp = new int[N + 1][NUM_CNT];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < NUM_CNT; j++) {
                minDp[i][j] = maxDp[i][j] = arr[i][j];
                if (j == 0) {
                    minDp[i][j] += Math.min(minDp[i - 1][j], minDp[i - 1][j + 1]);
                    maxDp[i][j] += Math.max(maxDp[i - 1][j], maxDp[i - 1][j + 1]);
                } else if (j == NUM_CNT - 1) {
                    minDp[i][j] += Math.min(minDp[i - 1][j - 1], minDp[i - 1][j]);
                    maxDp[i][j] += Math.max(maxDp[i - 1][j - 1], maxDp[i - 1][j]);
                } else {
                    minDp[i][j] += Math.min(minDp[i - 1][j - 1], Math.min(minDp[i - 1][j], minDp[i - 1][j + 1]));
                    maxDp[i][j] += Math.max(maxDp[i - 1][j - 1], Math.max(maxDp[i - 1][j], maxDp[i - 1][j + 1]));
                }
            }
        }

        for (int i = 0; i < NUM_CNT; i++) {
            answer[0] = Math.max(answer[0], maxDp[N][i]);
            answer[1] = Math.min(answer[1], minDp[N][i]);
        }

        return answer;
    }
}
