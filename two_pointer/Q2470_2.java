package two_pointer;

// https://www.acmicpc.net/problem/2470
// 두 용액

import java.io.*;
import java.util.*;

public class Q2470_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = solution(N, arr);
        bw.write(String.format("%d %d", answer[0], answer[1]));
        bw.close();
    }

    static int[] solution(int N, int[] arr) {
        Arrays.sort(arr);

        int[] answer = new int[2];
        int minDiff = Integer.MAX_VALUE;
        int start = 0, end = N - 1;
        while (start < end) {
            int diff = Math.abs(arr[start] + arr[end]);
            if (diff < minDiff) {
                minDiff = diff;
                answer[0] = arr[start];
                answer[1] = arr[end];
            }
            if (Math.abs(arr[start + 1] + arr[end]) < Math.abs(arr[start] + arr[end - 1])) start++;
            else end--;
        }

        return answer;
    }
}
