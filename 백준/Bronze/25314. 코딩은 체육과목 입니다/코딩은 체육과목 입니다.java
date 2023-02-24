import java.util.Scanner;

/**
 * 백준 - 25314
 * 브론즈V - 코딩은 체육과목 입니다
 * 전략
 * 1) 기초적인 반복문 문제
 */
public class Main {
  public static void main(String[] args) {
    int count = new Scanner(System.in).nextInt() / 4;
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < count; i++) {
      sb.append("long").append(' ');
    }

    System.out.println(sb.append("int"));

  }
}
