package dp;

// https://www.acmicpc.net/problem/1932
// 정수 삼각형

import java.io.*;
import java.util.*;

public class Q1932 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bw.write(Integer.toString(solution(N, arr)));
        br.close();
        bw.close();
    }

    static int solution(int N, int[][] arr) {
        int answer = 0;
        int[][] dp = new int[N][N];
        dp[0][0] = arr[0][0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                int a = (j - 1 >= 0 ? dp[i - 1][j - 1] : -1);
                int b = dp[i - 1][j];
                dp[i][j] = arr[i][j] + Math.max(a, b);
            }
        }

        for (int i = 0; i < N; i++) {
            answer = Math.max(dp[N - 1][i], answer);
        }

        return answer;
    }
}
