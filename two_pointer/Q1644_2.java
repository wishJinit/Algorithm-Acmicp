package two_pointer;

// https://www.acmicpc.net/problem/1644
// 소수의 연속합

import java.io.*;
import java.util.*;

public class Q1644_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(solution(Integer.parseInt(br.readLine()))));
        br.close();
        bw.close();
    }

    static int solution(int N) {
        int answer = 0;
        List<Integer> primeNumList = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            boolean isPrimeNum = true;
            for (int j = 2, len = (int) Math.sqrt(i); j <= len; j++) {
                if (i % j == 0) {
                    isPrimeNum = false;
                    break;
                }
            }
            if (isPrimeNum) primeNumList.add(i);
        }

        final int LEN = primeNumList.size();
        int start = 0, end = 0, sum = 0;
        while (end < LEN || sum > N) {
            if (sum >= N) sum -= primeNumList.get(start++);
            else sum += primeNumList.get(end++);
            if (sum == N) answer++;
        }

        return answer;
    }
}
