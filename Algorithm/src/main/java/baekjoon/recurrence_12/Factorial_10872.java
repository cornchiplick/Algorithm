package baekjoon.recurrence_12;

import java.util.Scanner;

/**
 * 백준 - 10872
 * 브론즈V - 팩토리얼
 * 단계별로 풀어보기 - 재귀
 * 재귀함수 설계능력이 부족하다고 판단하여 진행하는 단계별로 풀어보기 - 재귀 편 : 반드시 재귀함수를 사용하여 풀 것이다.
 * 전략
 * 1) 주어진 n이 1보다 작다면 1을 return 한다. (1! == 1 이므로)
 * 2) n이 1이 되는 시점이 재귀함수의 break시점이므로 n부터 점차 감소하여 1이 될때까지 재귀호출 하도록 설계하였다.
 */
public class Factorial_10872 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();

    System.out.println(factorial(n));
  }

  private static int factorial(int n) {
    if (n <= 1) {
      return 1;
    }

    return n * factorial(n - 1);
  }
}
