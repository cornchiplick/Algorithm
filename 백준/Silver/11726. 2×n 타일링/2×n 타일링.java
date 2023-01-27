import java.util.Scanner;

/**
 * 백준 - 11726
 * 실버III - 2xn 타일링
 * 전략
 * 피보나치 수열과 같다.
 * 1) n-1개의 타일을 붙인 경우의 수 + 1개의 타일을 세우기 --> (1)
 * 2) n-1개의 타일을 붙인 경우의 수 + 2개의 타일을 눕히기 --> (2)
 * 3) 2)에서 타일을 눕혀야만 한다. 왜냐하면 세워서 '||'의 형태를 만들면 이는 다시 '|'과 '|'의 형태로 쪼개질 수 있기 때문이다.
 *    이는 1)에서의 경우에 반드시 겹치는 경우이다.
 * 4) 이미 한 번 계산한 사항에 대해 다시 계산하지 않는다는 동적계획법을 사용하기 위해 전역변수 results[]에 계산결과 값을 저장한다.
 * 중요) 나머지를 출력하는 것이기 때문에 최종연산 결과에 나머지를 구해준다고 생각하면 안된다. 연산 중간에 overflow가 발생하는 경우를 처리할 수 없기 때문이다.
 * 참고 : https://yabmoons.tistory.com/506
 */
public class Main {

  // 결과값 저장 필드
  static int[] results = new int[1001];

  public static void main(String[] args) {
    // 입력
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();

    // 출력
    System.out.println(dp(n));
  }

  private static int dp(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }

    // 이미 계산한 항목이라면 다시 계산하지 않는다.
    if (results[n] != 0) {
      return results[n];
    }

    return results[n] = (dp(n - 1) + dp(n - 2)) % 10007;

  }
}
