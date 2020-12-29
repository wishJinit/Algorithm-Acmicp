package string;

// https://www.acmicpc.net/problem/1764
// 듣보잡

import java.io.*;
import java.util.*;

public class Q1764 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        String[] arr1 = new String[N], arr2 = new String[M];

        for (int i = 0; i < N; i++) {
            arr1[i] = br.readLine();
        }
        for (int i = 0; i < M; i++) {
            arr2[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        String[] answer = solution(N, M, arr1, arr2);
        sb.append(answer.length).append("\n");
        Arrays.stream(answer).forEach(o -> sb.append(o).append("\n"));

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static String[] solution(int N, int M, String[] arr1, String[] arr2) {
        List<String> answerList = new ArrayList<>();
        if (N < M) {
            Set<String> set = new HashSet<>(Arrays.asList(arr2));
            for (int i = 0; i < N; i++) {
                String s = arr1[i];
                if (set.contains(s)) answerList.add(s);
            }
        } else {
            Set<String> set = new HashSet<>(Arrays.asList(arr1));
            for (int i = 0; i < M; i++) {
                String s = arr2[i];
                if (set.contains(s)) answerList.add(s);
            }
        }

        String[] answer = answerList.toArray(String[]::new);
        // Java 8에선 answerList.stream().toArray(String[]::new);로 사용해야 함
        Arrays.sort(answer);
        return answer;
    }
}
