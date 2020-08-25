package greedy;

// https://www.acmicpc.net/problem/9625
// BABBA

import java.io.*;

public class Q9625 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(parseInt(br.readLine())));
    }

    public static String solution(int K) {
        int A = 0, B = 1;
        for (int i = 1; i < K; i++) {
            int a = B, b = A + B;
            A = a;
            B = b;
        }
        return A + " " + B;
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}