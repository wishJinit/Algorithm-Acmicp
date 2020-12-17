package bruteforce;

// https://www.acmicpc.net/problem/1065
// 한수

import java.io.*;

public class Q1065 {
    final static int MAX_DOUBLE_DIGIT = 99;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(solution(N));
    }

    static int solution(int N) {
        int answer = Math.min(N, MAX_DOUBLE_DIGIT);

        for (int i = 100; i <= N; i++) {
            String s = Integer.toString(i);
            boolean isEquivalentSequence = true;
            int gap = s.charAt(1) - s.charAt(0);

            for (int j = 2, len = s.length(); j < len; j++) {
                if (s.charAt(j) - s.charAt(j - 1) != gap) {
                    isEquivalentSequence = false;
                    break;
                }
            }

            if (isEquivalentSequence) answer++;
        }

        return answer;
    }
}
