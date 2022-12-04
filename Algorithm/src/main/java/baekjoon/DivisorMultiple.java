package baekjoon;

import java.util.Scanner;

public class DivisorMultiple {

  public static void main(String[] args) {

    // 두 수 입력받기
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();

    // 최대공약수 구하기
    int max = -1;
    // 최대공약수가 커봤자 주어진 두 수보다 크지는 않다.
    for (int i = 1; i <= Math.min(a, b); i++) {
      if (max < i && a % i == 0 && b % i == 0) {
        max = i;
      }
    }

    // 최대공약수 출력
    System.out.println(max);
    // 최소공배수 = 최대공약수 * (a / 최대공약수) * (b / 최대공약수) = a * b / 최대공약수
    System.out.println(a * b / max);

  }
}
