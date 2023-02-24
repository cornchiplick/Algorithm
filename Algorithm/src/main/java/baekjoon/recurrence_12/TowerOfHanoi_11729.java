package baekjoon.recurrence_12;

import java.util.Scanner;

/**
 * 백준 - 11729
 * 실버I - 하노이 탑 이동 순
 * 단계별로 풀어보기 - 재귀
 * 재귀함수 설계능력이 부족하다고 판단하여 진행하는 단계별로 풀어보기 - 재귀 편 : 반드시 재귀함수를 사용하여 풀 것이다.
 * 전략
 * 1) n개의 원판을 1에서 3번 장대로 옮기는 것은 n개의 원판을 1에서 2번 장대로 옮기는 것과 같다.
 * 2) n개의 원판을 1에서 2번 장대로 옮기는 것은 n-1개의 원판을 1에서 3번 장대로 옮긴 후,
 *    가장 아래의 원판 하나를 2번 장대로 옮기고 다시 n-1개의 원판을 3에서 1번 장대로 옮기는 것과 같다.
 * 3) 하나의 원판만 옮기면 될 때까지 재귀호출 한다.
 */
public class TowerOfHanoi_11729 {

  private static StringBuilder sb = new StringBuilder();

  // 원판을 옮길 때마다 횟수를 카운트한다.
  private static int count = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();

    hanoi(1, 3, n);

    System.out.printf("%d\n%s", count, sb);

  }

  private static void hanoi(int x, int y, int n) {
    // 1 2 3번 장대의 번호 합은 6이 되므로 두 개의 장대 번호가 주어진다면, 나머지 하나의 장대번호를 알 수 있다.
    int z = 6 - x - y;

    // 원판 하나만 옮길때(종결조건)
    if (n == 1) {
      sb.append(x).append(' ').append(y).append('\n');
      count++;
      return;
    }

    // n-1개의 원판을 목표장대가 아닌 다른 장대로 옮긴 후
    hanoi(x, z, n - 1);

    // 맨 아래의 원판을 목표 장대로 옮기고
    sb.append(x).append(' ').append(y).append('\n');
    count++;

    // 목표장대가 아닌 곳에 있는 n-1개의 원판을 다시 목표장대로 옮긴다.
    hanoi(z, y, n - 1);

  }
}
