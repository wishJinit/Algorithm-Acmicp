package etc;

// https://www.acmicpc.net/problem/1026
// 보물

import java.io.*;
import java.util.*;

public class Q1026 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] A = new Integer[N];
		Integer[] B = new Integer[N];
		
		String[] s = br.readLine().split(" ");
		for(int i = 0; i < N; i++)
			A[i] = Integer.parseInt(s[i]);
		
		s = br.readLine().split(" ");
		for(int i = 0; i < N; i++)
			B[i] = Integer.parseInt(s[i]);
		
		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());
		
		int sum = 0;
		for(int i = 0; i < N; i++)
			sum += A[i]*B[i];
		
		System.out.println(sum);
	}
}
