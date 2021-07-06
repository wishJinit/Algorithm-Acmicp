package bfs;

// https://www.acmicpc.net/problem/18352
// 특정 거리의 도시 찾기

import java.io.*;
import java.util.*;

public class Q18352 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arrayLists.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
            arrayLists.get(A).add(B);
        }

        int[] answer = solution(N, M, K, X, arrayLists);
        StringBuilder sb = new StringBuilder();
        for (int i = 1, len = answer.length; i < len; i++) {
            if (answer[i] == K) sb.append(i).append("\n");
        }
        bw.write(sb.length() == 0 ? "-1" : sb.toString());
        bw.close();
    }

    static int[] solution(int N, int M, int K, int X, ArrayList<ArrayList<Integer>> arrayLists) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visit = new int[N + 1];
        Arrays.fill(visit, -1);

        queue.add(X);
        visit[X] = 0;

        while (!queue.isEmpty()) {
            int idx = queue.poll();
            for (int i : arrayLists.get(idx)) {
                if (visit[i] == -1) {
                    visit[i] = visit[idx] + 1;
                    if (visit[i] < K) {
                        queue.offer(i);
                    }
                }
            }
        }

        return visit;
    }
}
