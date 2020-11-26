package dp;

// https://www.acmicpc.net/problem/16395
// 파스칼의 삼각형

import java.io.*;
import java.util.*;

public class Q16395 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        System.out.println(solution(N, K));
    }

    static int solution(int N, int K) {
        int[][] arr = new int[K][N];
        Arrays.fill(arr[0], 1);
        for (int i = 0; i < K; i++) arr[i][0] = 1;

        for (int i = 1; i < K; i++) {
            for (int j = 1; j < N - i; j++) {
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
            }
        }

        return arr[K - 1][N - K];
    }
}
