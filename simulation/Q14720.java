package simulation;

// https://www.acmicpc.net/problem/14720
// 우유 축제

import java.io.*;
import java.util.*;

public class Q14720 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, arr));
    }

    private static int solution(int N, int[] arr) {
        int answer = 0, position = 0;

        for(int i = 0; i < N; i++) {
            if(arr[i] == position) {
                answer++;
                if(position == 2) position = 0;
                else position++;
            }
        }

        return answer;
    }
}
