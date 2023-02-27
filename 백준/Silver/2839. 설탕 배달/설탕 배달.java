import java.util.Scanner;

/**
 * 백준 - 2839
 * 실버IV - 설탕 배달
 * 전략
 * 1) 3씩 빼가며 5의 배수인지 확인하여 최종 개수 출력
 */
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();
    int temp = 0;
    int answer = 0;

    while (n >= 3) {
      if (n % 5 == 0) {
        answer += n / 5;
        n %= 5;
      } else {
        answer += 1;
        n -= 3;
      }
    }

    if (n != 0) {
      System.out.println(-1);
    } else {
      System.out.println(answer);
    }
  }

}
