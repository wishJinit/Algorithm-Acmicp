package backtracking;

// https://www.acmicpc.net/problem/6603
// 로또


import java.io.*;
import java.util.*;

public class Q6603 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = parseInt(st.nextToken());
            if (k == 0) return;

            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = parseInt(st.nextToken());
            }
            dfs(k, arr, 0, "", 0);
            System.out.println();
        }
    }

    public static void dfs(int k, int[] arr, int index, String answer, int depth) {
        if (depth == 6) {
            System.out.println(answer);
            return;
        }
        for (int i = index; i < k; i++) {
            dfs(k, arr, i+1, answer + arr[i] + " ", depth + 1);
        }
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}
