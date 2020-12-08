package simulation;

// https://www.acmicpc.net/problem/1138
// 한 줄로 서기

import java.io.*;
import java.util.*;

public class Q1138 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i][0] = i + 1;
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.stream(solution(N, arr)).forEach(o1 -> sb.append(o1[0]).append(" "));
        System.out.println(sb.toString());
    }

    static int[][] solution(int N, int[][] arr) {
        int[][] answer = new int[N][2];

        for (int i = 0; i < N; i++) answer[i][1] = -1;
        for (int i = N - 1; i >= 0; i--) {
            int height = arr[i][0], peopleCnt = arr[i][1], cnt = 0;
            for (int j = 0; j < N; j++) {
                if (peopleCnt > cnt) cnt++;
                else if (peopleCnt == cnt) {
                    for (int z = N - 2; z >= j; z--) {
                        if (answer[z][1] == -1) continue;
                        answer[z + 1][0] = answer[z][0];
                        answer[z + 1][1] = answer[z][1];
                    }
                    answer[j][0] = height;
                    answer[j][1] = peopleCnt;
                    break;
                }
            }
        }

        return answer;
    }
}
