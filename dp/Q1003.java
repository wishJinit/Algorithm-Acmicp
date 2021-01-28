package dp;

// https://www.acmicpc.net/problem/1003
// 피보나치 함수

import java.io.*;

public class Q1003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        int max = 0;

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            max = Math.max(max, N);
            arr[t] = N;
        }

        int[][] fibonacci = new int[max + 1][2];

        fibonacci[0][0] = 1;
        if (max >= 1) fibonacci[1][1] = 1;

        for (int i = 2; i <= max; i++) {
            fibonacci[i][0] = fibonacci[i - 1][0] + fibonacci[i - 2][0];
            fibonacci[i][1] = fibonacci[i - 1][1] + fibonacci[i - 2][1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(fibonacci[arr[i]][0]).append(" ").append(fibonacci[arr[i]][1]).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
