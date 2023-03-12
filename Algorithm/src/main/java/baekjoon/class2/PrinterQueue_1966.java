package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 - 1966
 * 실버III - 프린터 큐
 * 전략
 * 1) location과 prior를 필드로 갖는 Print객체를 만든다.
 * 2) 각각의 Print 객체를 Queue에 넣는다.
 * 3) 찾는 location의 Print가 몇 번째로 인쇄되는지 계산하여 출력한다.
 */
public class PrinterQueue_1966 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    StringTokenizer st;

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < t; i++) {
      st = new StringTokenizer(br.readLine());
      int[] priorities = new int[Integer.parseInt(st.nextToken())];
      int location = Integer.parseInt(st.nextToken());
      
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < priorities.length; j++) {
        priorities[j] = Integer.parseInt(st.nextToken());
      }

      sb.append(findSequence(priorities, location)).append("\n");
    }
    System.out.println(sb);
  }

  public static int findSequence(int[] priorities, int location) {
    Queue<Print> q = new ArrayDeque<>();

    for (int i = 0; i < priorities.length; i++) {
      q.offer(new Print(i,priorities[i]));
    }

    int count = 1;

    while (!q.isEmpty()) {
      int prior = q.peek().prior;
      boolean condition = true;

      for (Print prt: q) {
        if (prior < prt.prior) {
          condition = false;
          break;
        }
      }

      if (condition) {
        if (q.peek().location == location) {
          return count;
        } else {
          count++;
          q.poll();
        }
      } else {
        q.offer(q.poll());
      }
    }

    return 0;
  }

}

class Print {
  int location;
  int prior;

  Print(int location, int prior) {
    this.location = location;
    this.prior = prior;
  }
}
