package greedy;

// https://www.acmicpc.net/problem/2217
// 로프

import java.io.*;
import java.util.*;

public class Q2217 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = parseInt(br.readLine());

        System.out.println(solution(N, arr));
    }

    public static int solution(int N, int[] arr) {
        int result = 0;

        Arrays.sort(arr);
        for(int i = 0; i < N; i++)
            result = Math.max(arr[i] * (N-i), result);

        return result;
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}