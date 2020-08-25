package greedy;

// https://www.acmicpc.net/problem/1541
// 잃어버린 괄호

import java.io.*;

public class Q1541 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));
    }

    public static int solution(String str) {
        int result = 0;
        String[] plus = str.split("-");
        for(int i = 0, len = plus.length; i < len; i++) {
            for(String sum : plus[i].split("\\+")) {
                if(i == 0) {
                    result += parseInt(sum);
                } else {
                    result -= parseInt(sum);
                }
            }
        }

        return result;
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}