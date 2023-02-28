package baekjoon.class2;

import java.util.Scanner;

/**
 * 백준 - 15829
 * 브론즈II - Hashing
 * 전략
 * 1) long 자료형의 범위를 넘어가지 않도록 중간과정에서 계속 %연산을 통해 값을 줄여준다.
 */
public class Hashing_15829 {
  private static final long factor = 1234567891;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int len = sc.nextInt();
    String str = sc.next();
    long c;
    long temp;
    long sum;
    long answer = 0;


    for (int i = 0; i < len; i++) {
      c = str.charAt(i) - 'a' + 1;

      // 31의 i제곱의 나머지
      temp = 1;
      for (int j = 0; j < i; j++) {
        temp *= 31;
        temp %= factor;
      }

      sum = (c * temp) % factor;
      answer = (answer + sum) % factor;
    }

    System.out.println(answer);
  }
}
