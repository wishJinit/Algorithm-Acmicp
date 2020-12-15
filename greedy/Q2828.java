package greedy;

// https://www.acmicpc.net/problem/2828
// 사과 담기 게임

import java.io.*;
import java.util.*;

public class Q2828 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken()), M = parseInt(st.nextToken()), J = parseInt(br.readLine());
        int[] arr = new int[J];

        for (int i = 0; i < J; i++) {
            arr[i] = parseInt(br.readLine());
        }

        System.out.println(solution(N, M, J, arr));
    }

    static int solution(int N, int M, int J, int[] arr) {
        int answer = 0;
        int start = 1, end = M;

        for (int i = 0; i < J; i++) {
            int value = arr[i];
            if (start <= value && value <= end) continue;
            if (end < value) {
                int endDiff = value - end;
                answer += endDiff;
                start += endDiff;
                end += endDiff;
            } else {
                int startDiff = start - value;
                answer += startDiff;
                start -= startDiff;
                end -= startDiff;
            }
        }

        return answer;
    }

    private static int parseInt(String s) {
        return Integer.parseInt(s);
    }
}
