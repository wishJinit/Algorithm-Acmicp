package greedy;

// https://www.acmicpc.net/problem/1439
// 뒤집기

import java.io.*;

public class Q1439_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Integer.toString(solution(br.readLine())));
        bw.close();
    }

    static int solution(String s) {
        int cnt = 1;
        char c = s.charAt(0);
        for (int i = 1, len = s.length(); i < len; i++) {
            char currentC = s.charAt(i);
            if (c != currentC) {
                cnt++;
                c = currentC;
            }
        }
        return cnt / 2;
    }
}
