import java.util.Scanner;

/**
 * 백준 - 10870
 * 브론즈II - 피보나치 수 5
 * 단계별로 풀어보기 - 재귀
 * 재귀함수 설계능력이 부족하다고 판단하여 진행하는 단계별로 풀어보기 - 재귀 편 : 반드시 재귀함수를 사용하여 풀 것이다.
 * 전략
 * 1) n이 0일때와 1일때의 return값을 (점화식의 초기값을) 지정해준다.
 * 2) 바로 앞 두 항의 값을 더한 값이 현재 항의 값이 되므로 재귀호출하여 return한다.
 */
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();

    System.out.println(fibo(n));
  }

  private static int fibo(int n) {
    if (n == 0) {
      return 0;
    }

    if (n == 1) {
      return 1;
    }

    return fibo(n - 1) + fibo(n - 2);
  }
}
