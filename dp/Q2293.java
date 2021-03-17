package dp;

// https://www.acmicpc.net/problem/2293
// 동전 1

import java.io.*;
import java.util.*;

public class Q2293 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(Integer.toString(solution(n, k, arr)));
        bw.close();
        br.close();
    }

    static int solution(int n, int k, int[] arr) {
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                int value = dp[i - 1][j];
                if (j - arr[i] >= 0) value += dp[i][j - arr[i]];
                dp[i][j] = value;
            }
        }

        return dp[n][k];
    }
}
