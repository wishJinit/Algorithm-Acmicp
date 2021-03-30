package binary_search;

// https://www.acmicpc.net/problem/2110
// 공유기 설치

import java.io.*;
import java.util.*;

public class Q2110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(Integer.toString(solution(N, C, arr)));
        bw.close();
    }

    static int solution(int N, int C, int[] arr) {
        int answer = 1;
        Arrays.sort(arr);

        int start = 1, end = arr[N - 1] - arr[0];
        while (start <= end) {
            int mid = (start + end) >> 1;
            int nextHome = arr[0] + mid;
            int cnt = 1;
            for (int i = 1; i < N; i++) {
                if (arr[i] >= nextHome) {
                    cnt++;
                    nextHome = arr[i] + mid;
                }
            }

            if (cnt >= C) {
                start = mid + 1;
                answer = mid;
            } else {
                end = mid - 1;
            }
        }

        return answer;
    }
}
