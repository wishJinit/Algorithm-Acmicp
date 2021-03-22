package binary_search;

// https://www.acmicpc.net/problem/1920
// 수 찾기

import java.io.*;
import java.util.*;

public class Q1920 {
    private final static int INCLUDE = 1, NOT_INCLUDE = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            B[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        Arrays.stream(solution(N, A, M, B)).forEach(o -> {
            sb.append(o).append("\n");
        });
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static int[] solution(int N, int[] A, int M, int[] B) {
        Arrays.sort(A);

        int[] answer = new int[M];
        for (int i = 0; i < M; i++) {
            answer[i] = binarySearch(N, A, B[i]);
        }
        return answer;
    }

    private static int binarySearch(int N, int[] A, int num) {
        int answer = NOT_INCLUDE;
        int start = 0, end = N - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (A[mid] < num) {
                start = mid + 1;
            } else if (A[mid] > num) {
                end = mid - 1;
            } else {
                answer = INCLUDE;
                break;
            }
        }
        return answer;
    }
}
