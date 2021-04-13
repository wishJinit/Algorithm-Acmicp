package math;

// https://www.acmicpc.net/problem/1676
// 팩토리얼 0의 개수

import java.io.*;

public class Q1676 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        bw.write(Integer.toString(solution(N)));
        bw.close();
    }

    static int solution(int N) {
        int cnt = 0;

        while (N >= 5) {
            cnt += N / 5;
            N /= 5;
        }

        return cnt;
    }
}
