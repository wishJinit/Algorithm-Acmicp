package two_pointer;

// https://www.acmicpc.net/problem/1806
// 부분합

import java.io.*;
import java.util.*;

public class Q1806_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(Integer.toString(solution(N, S, arr)));
        bw.close();
    }

    static int solution(int N, int S, int[] arr) {
        int answer = Integer.MAX_VALUE;
        int start = 0, end = 1;
        long sum = arr[start];
        while (start <= end) {
            if (sum < S) {
                if (end == N) break;
                sum += arr[end++];
            } else {
                answer = Math.min(answer, end - start);
                sum -= arr[start++];
            }
        }
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
