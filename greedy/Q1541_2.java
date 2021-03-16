package greedy;

// https://www.acmicpc.net/problem/1541
// 잃어버린 괄호

import java.io.*;
import java.util.*;

public class Q1541_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();

        bw.write(Integer.toString(solution(s)));
        bw.close();
        br.close();
    }

    static int solution(String s) {
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();

        boolean needPlus = false;
        for (char c : chars) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                int value = Integer.parseInt(sb.toString());
                if (needPlus) {
                    deque.addLast(deque.pollLast() + value);
                } else {
                    deque.addLast(value);
                }
                needPlus = c == '+';
                sb.delete(0, sb.length());
            }
        }

        deque.addLast(Integer.parseInt(sb.toString()));
        if (needPlus) {
            deque.addLast(deque.pollLast() + deque.pollLast());
        }

        int answer = deque.pollFirst();
        while (!deque.isEmpty()) {
            answer -= deque.pollFirst();
        }
        return answer;
    }
}
