package bfs;

// https://www.acmicpc.net/problem/11725
// 트리의 부모 찾기

import java.io.*;
import java.util.*;

public class Q11725 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        List<Integer>[] lists = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }

        StringBuilder sb = new StringBuilder();
        for (int n : solution(N, lists)) {
            sb.append(n).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }

    static int[] solution(int N, List<Integer>[] lists) {
        int[] answer = new int[N - 1];

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];

        queue.add(1);
        visit[1] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int child : lists[node]) {
                if (!visit[child]) {
                    answer[child - 2] = node;
                    queue.add(child);
                    visit[child] = true;
                }
            }
        }

        return answer;
    }
}
