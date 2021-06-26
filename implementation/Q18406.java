package implementation;

// https://www.acmicpc.net/problem/18406
// 럭키 스트레이트

import java.io.*;

public class Q18406 {
    private static final String LUCKY = "LUCKY";
    private static final String READY = "READY";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(solution(br.readLine()));
        bw.close();
    }

    static String solution(String s) {
        final int LEN = s.length();
        final int MID_LEN = LEN / 2;

        int sum = 0;
        for (int i = 0; i < MID_LEN; i++) {
            sum += s.charAt(i);
        }
        for (int i = MID_LEN; i < LEN; i++) {
            sum -= s.charAt(i);
        }

        return sum == 0 ? LUCKY : READY;
    }
}
