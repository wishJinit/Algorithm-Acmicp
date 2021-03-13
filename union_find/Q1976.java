package union_find;

// https://www.acmicpc.net/problem/1976
// 여행 가자

import java.util.*;
import java.io.*;

public class Q1976 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = parseInt(br.readLine()), M = parseInt(br.readLine());

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int value = parseInt(st.nextToken());
                if (i < j) {
                    if (value == 1) {
                        union(arr, i, j);
                    }
                }
            }
        }

        boolean answer = true;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int parent = find(arr, parseInt(st.nextToken()));
        for (int i = 2; i <= M; i++) {
            int value = find(arr, parseInt(st.nextToken()));
            if (parent != value) {
                answer = false;
                break;
            }
        }

        bw.write(answer ? "YES" : "NO");
        bw.close();
        br.close();
    }

    private static int find(int[] arr, int idx) {
        if (arr[idx] == idx) return idx;
        else return arr[idx] = find(arr, arr[idx]);
    }

    private static void union(int[] arr, int a, int b) {
        int aa = find(arr, a), bb = find(arr, b);
        if (aa != bb) {
            arr[aa] = bb;
        }
    }

    private static int parseInt(String s) {
        return Integer.parseInt(s);
    }
}

