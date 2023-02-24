import java.util.Scanner;

/**
 * 백준 - 14681
 * 브론즈V - 사분면 고르기
 * 전략
 * 1) 기초적인 조건문 문제
 */
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    int y = sc.nextInt();

    if (x >= 0) {
      if (y >= 0) {
        System.out.println(1);
      } else {
        System.out.println(4);
      }
    } else {
      if (y >= 0) {
        System.out.println(2);
      } else {
        System.out.println(3);
      }
    }
  }
}
