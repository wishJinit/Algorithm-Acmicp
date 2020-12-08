package greedy;

// https://www.acmicpc.net/problem/1439
// 뒤집기

import java.io.*;

public class Q1439 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
    }

    static int solution(String s) {
        int answer = 1, pieceCnt = 1;
        char firstChar = s.charAt(0);
        for (int i = 1, len = s.length(); i < len; i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                if (s.charAt(i) == firstChar) answer++;
                pieceCnt++;
            }
        }
        return Math.min(answer, pieceCnt - answer);
    }
}
