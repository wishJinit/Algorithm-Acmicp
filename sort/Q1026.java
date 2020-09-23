package sort;

// https://www.acmicpc.net/problem/1026
// 보물

import java.io.*;
import java.util.*;

public class Q1026 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        int[] A = new int[N], B = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) B[i] = parseInt(st.nextToken());

        System.out.println(solution(N, A, B));
    }

    public static int solution(int N, int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < N; i++) {
            answer += A[i] * B[N - i - 1];
        }
        return answer;
    }

    private static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}
