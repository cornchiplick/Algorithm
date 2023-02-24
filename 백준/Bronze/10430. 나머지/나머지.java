import java.util.Scanner;

/**
 * 백준 - 10430
 * 브론즈V - 나머지
 * 전략
 * 1) 기초적인 사칙연산 문제
 */
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    StringBuilder sb = new StringBuilder();

    sb.append((a + b) % c).append('\n');
    sb.append(((a % c) + (b % c)) % c).append('\n');
    sb.append((a * b) % c).append('\n');
    sb.append(((a % c) * (b % c)) % c);
    System.out.println(sb);

  }
}
