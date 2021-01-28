package dp;

// https://www.acmicpc.net/problem/2579
// 계단 오르기

import java.io.*;

public class Q2579_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(Integer.toString(solution(N, arr)));
        br.close();
        bw.close();
    }

    static int solution(int N, int[] arr) {
        int[] dp = new int[N + 1];
        dp[1] = arr[1];
        if (N >= 2) {
            dp[2] = arr[1] + arr[2];
            for (int i = 3; i <= N; i++) {
                dp[i] = Math.max(arr[i - 1] + dp[i - 3], dp[i - 2]) + arr[i];
            }
        }

        return dp[N];
    }
}
