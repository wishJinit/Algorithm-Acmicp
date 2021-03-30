package binary_search;

// https://www.acmicpc.net/problem/1654
// 랜선 자르기

import java.io.*;
import java.util.*;

public class Q1654 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(Integer.toString(solution(K, N, arr)));
        bw.close();
        br.close();
    }

    static int solution(int K, int N, int[] arr) {
        int answer = 1;

        long sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }

        long start = 0, end = sum / N, mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            long cnt = 0;
            for (int i = 0; i < K; i++) {
                if (mid == 0) break;
                cnt += arr[i] / mid;
            }
            if (cnt >= N) {
                start = mid + 1;
                answer = (int) mid;
            } else end = mid - 1;
        }

        return answer;
    }
}
