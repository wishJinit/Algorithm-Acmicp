package greedy;

// https://www.acmicpc.net/problem/2828
// 사과 담기 게임

import java.io.*;

public class Q2810 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        System.out.println(solution(N, s));
    }

    static int solution(int N, String s) {
        int answer = N, lCnt = -1;

        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == 'S') {
                i++;
                lCnt++;
            }
        }

        if (lCnt > 0) answer -= lCnt;

        return answer;
    }
}
