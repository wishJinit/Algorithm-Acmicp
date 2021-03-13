package dp;

// https://www.acmicpc.net/problem/10870
// 피보나치 수 5

import java.io.*;

public class Q10870 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write(Integer.toString(solution(N)));
        bw.close();
        br.close();
    }

    static int solution(int N) {
        int[] dp = new int[N + 1];

        if (N > 0) {
            dp[1] = 1;
        }

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[N];
    }
}
