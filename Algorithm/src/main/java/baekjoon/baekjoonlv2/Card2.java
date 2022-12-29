package baekjoon.baekjoonlv2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Card2 {

  public static void main(String[] args) {

    // 입력값 n받기
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    // queue 선언
    Queue<Integer> q = new LinkedList<>();

    // queue에 1부터 n까지 순서대로 offer(=add)
    for (int i = 1; i <= n; i++) {
      q.offer(i);
    }

    // 마지막에 1개 남아야 하므로 size() > 1 조건으로
    while (q.size() > 1) {
      // 맨 앞에서 하나 빼고
      q.poll();

      // 그 다음 맨 앞에서 하나빼서 그걸 다시 맨 뒤로
      q.offer(q.poll());
    }

    System.out.println(q.poll());
  }
}
