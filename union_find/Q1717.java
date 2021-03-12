package union_find;

// https://www.acmicpc.net/problem/1717
// 집합의 표현

import java.util.*;
import java.io.*;

public class Q1717 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int flag = parseInt(st.nextToken()), a = parseInt(st.nextToken()), b = parseInt(st.nextToken());

            if (flag == 0) {
                union(arr, a, b);
            } else {
                sb.append((find(arr, a) == find(arr, b) ? "YES" : "NO")).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void union(int[] arr, int a, int b) {
        int aParent = find(arr, a), bParent = find(arr, b);
        if (aParent != bParent) {
            arr[bParent] = a;
        }
    }

    private static int find(int[] arr, int idx) {
        if (arr[idx] == idx) return idx;
        else {
            return arr[idx] = find(arr, arr[idx]);
        }
    }

    private static int parseInt(String s) {
        return Integer.parseInt(s);
    }
}
