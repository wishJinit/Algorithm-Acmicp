package two_pointer;

// TODO : 실패
// https://www.acmicpc.net/problem/2003
// 소수의 연속합

import java.io.*;
import java.util.*;

public class Q1644 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[N+1];
        int sum = 0, cnt = 0, start = 0, end = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();

        if(N == 1) { System.out.print(0); return; }

        check[2] = true;
        for(int i = 2; i <= N/2; i++)
            for(int j = 2; j <= N/i; j++)
                check[i*j] = true;

        for(int i = 2; i <= N; i++)
            if(!check[i]) arrayList.add(i);

        int as = arrayList.size();
        while(true) {
            if(sum < N) sum += arrayList.get(end++);
            else if(sum > N) sum -= arrayList.get(start++);
            else {
                sum += arrayList.get(end++);
                sum -= arrayList.get(start++);
            }
            if(sum == N) cnt++;
            if(end == as && sum <= N) break;
        }

        System.out.print(cnt);
    }
}
