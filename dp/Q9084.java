package dp;

// https://www.acmicpc.net/problem/9084
// 동전

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9084 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = parseInt(br.readLine());
        for (int z = 0; z < T; z++) {
            int N = parseInt(br.readLine());
            int[] coins = new int[N];
            String[] str = br.readLine().split(" ");
            for (int i = 0, len = str.length; i < len; i++) coins[i] = parseInt(str[i]);
            int M = parseInt(br.readLine());
            sb.append(solution(N, coins, M)).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int solution(int N, int[] coins, int M) {
        int[] dp = new int[M + 1];
        for (int i = 1; i <= N; i++) {
            int coin = coins[i-1];
            dp[0] = 1;
            for (int j = coin; j <= M; j++) dp[j] += dp[j - coin];
        }
        return dp[M];
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}