package sort;

// https://www.acmicpc.net/problem/10825
// 국영수

import java.io.*;
import java.util.*;

public class Q10825 {
    private static class Student implements Comparable<Student> {
        String name;
        int kor, eng, math;

        Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if (kor != o.kor) return Integer.compare(o.kor, kor);
            else if (eng != o.eng) return Integer.compare(eng, o.eng);
            else if (math != o.math) return Integer.compare(o.math, math);
            return name.compareTo(o.name);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            list.add(new Student(name, kor, eng, math));
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (Student s : list) {
            sb.append(s.name).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}
