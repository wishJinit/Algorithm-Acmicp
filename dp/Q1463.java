package dp;

// https://www.acmicpc.net/problem/1463
// 1로 만들기

import java.io.*;

public class Q1463 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        bw.write(Integer.toString(solution(N)));
        br.close();
        bw.close();
    }

    static int solution(int N) {
        if (N == 1) return 0;
        else if (N <= 3) return 1;
        int[] arr = new int[N + 1];
        arr[2] = arr[3] = 1;

        for (int i = 4; i <= N; i++) {
            int a = arr[i - 1];
            int b = (i % 3 == 0 ? arr[i / 3] : Integer.MAX_VALUE);
            int c = (i % 2 == 0 ? arr[i / 2] : Integer.MAX_VALUE);
            arr[i] = Math.min(a, Math.min(b, c)) + 1;
        }

        return arr[N];
    }
}
