package dp;

// https://www.acmicpc.net/problem/1965
// 상자넣기

import java.io.*;
import java.util.*;

public class Q1965 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        int[] arr = new int[N], dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = parseInt(st.nextToken());

        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] >= arr[i]) continue;
                cnt = Math.max(cnt, dp[j]);
            }
            dp[i] = cnt + 1;
        }

        int result = dp[0];
        for(int i = 1; i < N; i++) result = Math.max(result, dp[i]);
        System.out.println(result);
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}
