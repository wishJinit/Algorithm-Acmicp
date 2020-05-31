package dp;

// https://www.acmicpc.net/problem/1912
// 연속합

import java.io.*;

public class Q1912 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		String[] s = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(s[i]);
			dp[i] = arr[i];
		}

		int result = dp[0];
		for(int i = 1; i < N; i++) {
			dp[i] = Math.max(arr[i] + dp[i-1], dp[i]);
			result = Math.max(dp[i], result);
		}
		
		System.out.println(result);
	}
}
