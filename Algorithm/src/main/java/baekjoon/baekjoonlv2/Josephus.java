package baekjoon.baekjoonlv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Josephus {

  public static void main(String[] args) throws IOException {

    // N과 K 입력 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    br.close();

    // Queue에 1부터 N까지 추가
    Queue<Integer> q = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      q.offer(i);
    }

    // 출력 문자열
    StringBuilder sb = new StringBuilder();
    sb.append('<');

    // 큐가 빌때까지 K번째 숫자 제거
    int count = 0;
    while (!q.isEmpty()) {
      count++;
      if (count == K) {
        sb.append(q.poll()).append(',').append(' ');
        count = 0;
      } else {
        q.offer(q.poll());
      }
    }

    System.out.println(sb.substring(0, sb.toString().length() - 2) + ">");


  }
}
