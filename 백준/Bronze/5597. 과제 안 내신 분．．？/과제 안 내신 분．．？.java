import java.util.Scanner;

/**
 * 백준 - 5597
 * 브론즈V - 과제 안 내신 분..?
 * 전략
 * 1) 기초적인 문제
 */
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean[] arr = new boolean[30];

    for (int i = 0; i < 28; i++) {
      arr[sc.nextInt() - 1] = true;
    }

    int count = 0;
    for (boolean element : arr) {
      count++;
      if (!element) {
        System.out.println(count);
      }
    }
  }
}
