package simulation;

// https://www.acmicpc.net/problem/1037
// 약수

import java.io.*;
import java.util.*;

public class Q1037 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(Long.toString(solution(N, arr)));
        bw.close();
    }

    static int solution(int N, int[] arr) {
        Arrays.sort(arr);
        if (N == 1) return arr[0] * arr[0];
        else return arr[0] * arr[N - 1];
    }
}
