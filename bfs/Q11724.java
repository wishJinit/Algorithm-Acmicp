package bfs;

// https://www.acmicpc.net/problem/11724
// 연결 요소의 개수

import java.io.*;
import java.util.*;

public class Q11724 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            setMap(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), map);
        }

        System.out.println(solution(N, map));
    }

    static void setMap(int u, int v, boolean[][] map) {
        map[u][v] = map[v][u] = true;
    }

    static int solution(int N, boolean[][] map) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisit = new boolean[N + 1];
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            if (!isVisit[i]) {
                queue.add(i);
                isVisit[i] = true;
                answer++;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int j = 1; j <= N; j++) {
                        if (map[node][j] && !isVisit[j]) {
                            queue.add(j);
                            isVisit[j] = true;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
