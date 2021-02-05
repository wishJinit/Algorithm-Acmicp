package dp;

// https://www.acmicpc.net/problem/1912
// 연속합

import java.io.*;
import java.util.*;

public class Q1912_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(Integer.toString(solution(N, arr)));
        br.close();
        bw.close();
    }

    static int solution(int N, int[] arr) {
        int answer = arr[0];
        int[] dp = new int[N];

        dp[0] = arr[0];
        for (int i = 1; i < N; i++) {
            dp[i] = dp[i - 1] + arr[i];
            dp[i] = Math.max(dp[i], 0);
            answer = Math.max(dp[i], answer);
        }

        if (answer == 0) {
            Arrays.sort(arr);
            answer = arr[N - 1];
        }

        return answer;
    }
}
