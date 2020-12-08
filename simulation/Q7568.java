package simulation;

// TODO : 다시 풀어보기
// https://www.acmicpc.net/problem/7568
// 덩치

import java.io.*;
import java.util.*;

public class Q7568 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.stream(solution(N, arr)).forEach(o1 -> sb.append(o1).append(" "));
        System.out.println(sb.toString());
    }

    static int[] solution(int N, int[][] arr) {
        int[] rank = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) rank[i]++;
                if (arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]) rank[j]++;
            }
        }

        return rank;
    }
}
