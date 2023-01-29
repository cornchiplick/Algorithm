import java.util.Scanner;

/**
 * 백준 - 2748
 * 브론즈I - 피보나치 수 2
 * 전략
 * 1) 피보나치 수열 구현
 * 2) dynamic programming 구현
 * 주의사항
 * 1) n의 값이 너무 커지면 int자료형으로는 표현할 수 없다.
 */
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();

    long[] dp = new long[91];
    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    System.out.println(dp[n]);

  }
}
