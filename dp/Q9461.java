package dp;

// https://www.acmicpc.net/problem/9461
// 파도반 수열

import java.io.*;

public class Q9461 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];

        int max = 0;
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long[] dp = solution(max);

        StringBuilder sb = new StringBuilder();
        for (int n : arr) {
            sb.append(dp[n]).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static long[] solution(int max) {
        long[] dp = new long[max + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= max; i++) {
            dp[i] = dp[i - 3] + dp[i - 2];
        }
        return dp;
    }
}
