package greedy;

// https://www.acmicpc.net/problem/2217
// 로프

import java.io.*;
import java.util.*;

public class Q2217_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(Integer.toString(solution(N, arr)));
        br.close();
        bw.close();
    }

    static int solution(int N, int[] arr) {
        int max = arr[N - 1];
        Arrays.sort(arr);
        for (int i = N - 2; i >= 0; i--) {
            int value = arr[i] * (N - i);
            max = Math.max(value, max);
        }
        return max;
    }
}
