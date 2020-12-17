package backtracking;

// https://www.acmicpc.net/problem/10819
// 차이를 최대로

import java.io.*;
import java.util.*;

public class Q10819 {
    static int max = 0;
    static int currentIdx = 0;
    static int[] result;
    static boolean[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        result = new int[N];
        check = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        solution(N, arr);

        System.out.println(max);
    }

    static void solution(int N, int[] arr) {
        if (currentIdx == N) {
            int sum = 0;
            for (int i = 1; i < N; i++) {
                sum += Math.abs(result[i - 1] - result[i]);
            }
            max = Math.max(sum, max);
        }

        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                result[currentIdx++] = arr[i];
                check[i] = true;
                solution(N, arr);
                currentIdx--;
                check[i] = false;
            }
        }
    }
}
