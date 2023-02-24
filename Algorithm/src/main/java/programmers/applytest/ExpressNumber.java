package programmers.applytest;

import java.util.Scanner;

/**
 * 연정이의 프로그래머스의 '숫자의 표현' 이라는 문제 설명하는 용도로 작성되었다.
 */
public class ExpressNumber {
  public static void main(String[] args) {
    int sum = 0; // 0+1+2+...x-1
    int op = 0;
    int x = 1;
    int count = 0;

    int n = new Scanner(System.in).nextInt();

    while (sum < n) {
      if ((n - sum) % x == 0) {
        count++;
      }
      op++;
      sum += op;
      x++;
    }

    System.out.println(count);
  }

}
