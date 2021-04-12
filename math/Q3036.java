package math;

// https://www.acmicpc.net/problem/3036
// 링

import java.io.*;
import java.util.*;

public class Q3036 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(solution(N, arr));
        bw.close();
    }

    static String solution(int N, int[] arr) {
        StringBuilder sb = new StringBuilder();
        int first = arr[0];
        for (int i = 1; i < N; i++) {
            int ring = arr[i];
            int max = Math.max(first, ring);
            int min = Math.min(first, ring);
            int num = gcd(max, min);
            sb.append(String.format("%d/%d", first / num, ring / num)).append("\n");
        }
        return sb.toString();
    }

    private static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
