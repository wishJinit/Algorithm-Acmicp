package graph;

// https://www.acmicpc.net/problem/1197
// 최소 스패닝 트리

import java.io.*;
import java.util.*;

public class Q1197 {
    private static class Node implements Comparable<Node> {
        int idx, weight;

        Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());

        List<Node>[] lists = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            lists[i] = new ArrayList();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lists[a].add(new Node(b, c));
            lists[b].add(new Node(a, c));
        }

        bw.write(Integer.toString(solution(V, E, lists)));
        bw.close();
    }

    private static int solution(int V, int E, List<Node>[] lists) {
        Queue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[V + 1];

        pq.add(new Node(1, 0));

        int sum = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            int idx = n.idx;

            if (visit[idx]) continue;

            visit[idx] = true;
            sum += n.weight;

            if (++cnt == V) break;

            for (int i = 0, size = lists[idx].size(); i < size; i++) {
                Node nn = lists[idx].get(i);
                if (!visit[nn.idx]) {
                    pq.add(nn);
                }
            }
        }

        return sum;
    }
}
