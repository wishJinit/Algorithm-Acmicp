package binary_search;

// https://www.acmicpc.net/problem/2805
// 나무 자르기

import java.io.*;
import java.util.*;

public class Q2805 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        bw.write(Integer.toString(solution(N, M, max, arr)));
        bw.close();
        br.close();
    }

    static int solution(int N, int M, int max, int[] arr) {
        int answer = 0;

        long start = 0, end = max;
        while (start <= end) {
            long mid = (start + end) / 2, sum = 0;
            for (int i = 0; i < N; i++) {
                sum += Math.max(arr[i] - mid, 0);
            }
            if (sum >= M) {
                start = mid + 1;
                answer = Math.max((int) mid, answer);
            } else {
                end = mid - 1;
            }
        }

        return answer;
    }
}
