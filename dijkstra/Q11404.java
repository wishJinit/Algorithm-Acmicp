package dijkstra;

// https://www.acmicpc.net/problem/11404
// 플로이드

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Q11404 {
    final static int INF = 100_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
        int[][] arr = IntStream.range(0, N + 1)
                .mapToObj(r -> IntStream.range(0, N + 1).map(c -> (r == c ? 0 : INF)).toArray()).toArray(int[][]::new);

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = Math.min(arr[a][b], c);
        }

        for (int z = 1; z <= N; z++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][z] + arr[z][j]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++)
                sb.append((arr[i][j] >= INF ? 0 : arr[i][j])).append(" ");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
