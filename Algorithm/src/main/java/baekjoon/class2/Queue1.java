package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Queue1 {
  public static Deque q = new ArrayDeque();

  public static void main(String[] args) throws IOException {

    // N개의 명령을 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    // N개의 명령을 처리하기
    for (int i = 0; i < N; i++) {
      behavior(br);
    }

    br.close();

  }

  private static void behavior(BufferedReader br) throws IOException {
    String command = br.readLine();

    switch (command) {
      case "pop": {
        if (q.isEmpty()) {
          System.out.println(-1);
          break;
        }
        System.out.println(q.poll());
        break;
      }

      case "size": {
        System.out.println(q.size());
        break;
      }

      case "empty": {
        if (q.isEmpty()) {
          System.out.println(1);
        } else {
          System.out.println(0);
        }
        break;
      }

      case "front": {
        if (q.isEmpty()) {
          System.out.println(-1);
          break;
        }
        System.out.println(q.getFirst());
        break;
      }

      case "back": {
        if (q.isEmpty()) {
          System.out.println(-1);
          break;
        }
        System.out.println(q.getLast());
        break;
      }

      default: {
        q.offer(Integer.parseInt(command.substring(5)));
      }
    }

  }


}
