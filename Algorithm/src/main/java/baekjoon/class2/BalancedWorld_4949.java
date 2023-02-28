package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준 - 4949
 * 실버IV - 균형잡힌 세상
 * 전략
 * 1) 소괄호 체크하는 stack, 중괄호 체크하는 stack, 직전에 열린 괄호의 종류룰 체크하는 stack. 총 3개의 stack으로 관리한다.
 * 2) 최종적으로 check boolean이 true 일 때만 yes를 출력한다.
 */
public class BalancedWorld_4949 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    boolean check = true;
    char c;
    Stack<Integer> small;
    Stack<Integer> big;
    Stack<Integer> post;
    StringBuilder sb = new StringBuilder();

    while (!str.equals(".")) {
      check = true;
      small = new Stack<>();
      big = new Stack<>();
      post = new Stack<>();

      for (int i = 0; i < str.length() - 1; i++) {
        c = str.charAt(i);
        switch (c) {
          case '(': {
            post.push(1);
            small.push(1);
            break;
          }

          case ')': {
            if (!small.isEmpty() && !post.isEmpty()) {
              if (post.pop() == 1) {
                small.pop();
              } else {
                check = false;
              }
            } else {
              check = false;
            }
            break;
          }

          case '[': {
            post.push(2);
            big.push(1);
            break;
          }

          case ']': {
            if (!big.isEmpty() && !post.isEmpty()) {
              if (post.pop() == 2) {
                big.pop();
              } else {
                check = false;
              }
            } else {
              check = false;
            }
            break;
          }

          default:
            break;
        } // switch
      } // for

      if (!small.isEmpty() || !big.isEmpty()) {
        check = false;
      }

      if (check) {
        sb.append("yes").append('\n');
      } else {
        sb.append("no").append('\n');
      }
      str = br.readLine();
    } // while

    System.out.println(sb);
  }
}
