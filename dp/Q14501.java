package dp;

// TODO : 실패 - 해결
// https://www.acmicpc.net/problem/14501
// 퇴사

import java.util.*;
import java.io.*;

public class Q14501 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
		int[] dp = new int[N+1];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            if(arr[i][0] + i > N) arr[i][0] = -1;
        }

        for(int i = 0; i < N; i++) {
            if(arr[i][0] == -1) continue;
            for(int j = arr[i][0] + i; j <= N; j++)
                dp[j] = max(dp[i] + arr[i][1], dp[j]);
        }

        int result = -1;
        for(int i = 1; i <= N; i++)
            result = max(result, dp[i]);

        System.out.print(result);
    }

    private static int max(int a, int b) {
        return (a > b ? a : b);
    }
}