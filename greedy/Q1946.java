package greedy;

// https://www.acmicpc.net/problem/1946
// 신입 사원

import java.io.*;
import java.util.*;

public class Q1946 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int cnt = parseInt(br.readLine());
            int[][] arr = new int[cnt][2];
            for (int j = 0; j < cnt; j++) {
                String[] str = br.readLine().split(" ");
                arr[j][0] = parseInt(str[0]);
                arr[j][1] = parseInt(str[1]);
            }
            sb.append(solution(cnt, arr)).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int solution(int N, int[][] arr) {
        int result = N;

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return (Integer.compare(o1[1], o2[1]));
            } else {
                return (Integer.compare(o1[0], o2[0]));
            }
        });

        int min = arr[0][1];
        for (int i = 1; i < N; i++) {
            if (min > arr[i][1]) min = arr[i][1];
            else result--;
        }

        return result;
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}