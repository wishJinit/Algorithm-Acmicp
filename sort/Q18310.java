package sort;

// https://www.acmicpc.net/problem/18310
// 안테나

import java.io.*;
import java.util.*;

public class Q18310 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);
        bw.write(Integer.toString(list.get(N / 2 - 1)));
        bw.close();
    }
}
