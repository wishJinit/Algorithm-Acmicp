package greedy;

// https://www.acmicpc.net/problem/1931
// 회의실 배정

import java.io.*;
import java.util.*;

public class Q1931 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = parseInt(st.nextToken());
            arr[i][1] = parseInt(st.nextToken());
        }
        System.out.println(solution(N, arr));
    }

    public static int solution(int N, int[][] arr) {
        Arrays.sort(arr, ((o1, o2) -> {
            if (o1[1] != o2[1]) return Integer.compare(o1[1], o2[1]);
            else return Integer.compare(o1[0], o2[0]);
        }));

        int endTime = arr[0][1], cnt = 1;
        for (int i = 1; i < N; i++) {
            int startTime = arr[i][0];
            if (startTime < endTime) continue;
            endTime = arr[i][1];
            cnt++;
        }

        return cnt;
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}
