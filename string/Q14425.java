package string;

// https://www.acmicpc.net/problem/14425
// 문자열 집합

import java.io.*;
import java.util.*;

public class Q14425 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        String[] S = new String[N];
        for (int i = 0; i < N; i++) {
            S[i] = br.readLine();
        }

        String[] arr = new String[M];
        for (int i = 0; i < M; i++) {
            arr[i] = br.readLine();
        }

        bw.write(Integer.toString(solution(S, arr)));
        bw.close();
    }

    static int solution(String[] S, String[] arr) {
        int cnt = 0;
        Set<String> set = new HashSet<>(Arrays.asList(S));
        for (String s : arr) {
            if (set.contains(s)) cnt++;
        }
        return cnt;
    }
}
