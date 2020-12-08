package simulation;

// https://www.acmicpc.net/problem/10815
// 숫자 카드

import java.io.*;
import java.util.*;

public class Q10815 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.stream(solution(N, arr1, M, arr2)).forEach(o1 -> sb.append(o1).append(" "));
        System.out.println(sb.toString());
    }

    static int[] solution(int N, int[] arr1, int M, int[] arr2) {
        HashSet<Integer> hs = new HashSet<>();
        int[] answer = new int[M];

        for (int v : arr2) hs.add(v);
        for (int v : arr1) hs.remove(v);

        for (int i = 0; i < M; i++)
            if (!hs.contains(arr2[i])) answer[i] = 1;

        return answer;
    }
}
