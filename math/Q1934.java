package math;

// https://www.acmicpc.net/problem/1934
// 최소공배수

import java.io.*;
import java.util.*;

public class Q1934 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()), n2 = Integer.parseInt(st.nextToken());
            sb.append(solution(n1, n2)).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }

    static int solution(int n1, int n2) {
        int max = Math.max(n1, n2);
        int min = Math.min(n1, n2);
        int num = gcd(max, min);

        return n1 * n2 / num;
    }

    private static int gcd(int n1, int n2) {
        if (n1 % n2 == 0) return n2;
        return gcd(n2, n1 % n2);
    }
}
