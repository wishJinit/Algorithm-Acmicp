package dp;

//https://www.acmicpc.net/problem/11726
//2×n 타일링

import java.io.*;

public class Q11726 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if(N <= 3) {
			System.out.print(N);
			return;
		}
		
		int[] dp = new int[N+1];
		dp[2] = 2;
		dp[3] = 3;
		for(int i = 4; i <= N; i++)
			dp[i] = (dp[i-1] + dp[i-2]) % 10007;
		
		System.out.print(dp[N]);
	}
}
