import java.util.Scanner;

/**
 * 백준 - 1929
 * 실버III - 소수 구하기
 * 전략
 * 1) 에라스토테네스의 체를 이용한다
 */
public class Main {
  private static boolean[] prime;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
    sc.close();

    isPrime(n);

    StringBuilder sb = new StringBuilder();
    for (int i = 2; i < prime.length; i++) {
      if (i >= m && !prime[i]) {
        sb.append(i).append('\n');
      }
    }
    System.out.println(sb);

  }

  private static void isPrime(int n) {
    prime = new boolean[n + 1];
    if (n < 2) {
      return;
    }
    // 소수가 아니라면 true 이다.
    prime[0] = prime[1] = true;

    for(int i = 2; i <= Math.sqrt(n); i++) {

      // 이미 체크된 배열이면 다음 반복문으로 skip
      if(prime[i]) {
        continue;
      }

      // i 의 배수들을 걸러주기 위한 반복문
      for(int j = i * i; j < prime.length; j = j+i) {
        prime[j] = true;
      }
    }


  }
}
