package dp;

// https://www.acmicpc.net/problem/11053
// 가장 긴 증가하는 부분 수열

import java.io.*;
import java.util.*;

public class Q11053 {
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
        int[] dp = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            int idx = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j] && (idx == -1 || dp[idx] < dp[j])) idx = j;
            }
            dp[i] = (idx == -1 ? 0 : dp[idx]) + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
