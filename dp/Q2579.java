package dp;

// https://www.acmicpc.net/problem/2579
// 계단 오르기

import java.io.*;

public class Q2579 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		long[] dp = new long[N+1];
		
		for(int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		if(N == 1) {System.out.print(arr[1]); return;}
		
		dp[1] = arr[1];
		dp[2] = arr[2]+arr[1];
		
		for(int i = 3; i <= N; i++)
			dp[i] = Math.max(arr[i]+dp[i-2], dp[i-3]+arr[i]+arr[i-1]);

		System.out.print(dp[N]);
	}
}
