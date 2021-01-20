package greedy;

// https://www.acmicpc.net/problem/1931
// 회의실 배정

import java.io.*;
import java.util.*;

public class Q1931_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(Integer.toString(solution(N, arr)));
        br.close();
        bw.close();
    }

    static int solution(int N, int[][] arr) {
        int answer = 1;
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] != o2[1]) return Integer.compare(o1[1], o2[1]);
            else return Integer.compare(o1[0], o2[0]);
        });
        int[] endTime = arr[0];
        for (int i = 1; i < N; i++) {
            if (endTime[1] <= arr[i][0]) {
                endTime = arr[i];
                answer++;
            }
        }
        return answer;
    }
}
