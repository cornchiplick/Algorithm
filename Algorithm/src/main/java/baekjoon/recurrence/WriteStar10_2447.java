package baekjoon.recurrence;

import java.util.Scanner;

/**
 * 백준 - 2447
 * 골드V - 별 찍기 - 10
 * 단계별로 풀어보기 - 재귀
 * 재귀함수 설계능력이 부족하다고 판단하여 진행하는 단계별로 풀어보기 - 재귀 편 : 반드시 재귀함수를 사용하여 풀 것이다.
 * 전략
 * 1) 1 2 3 \n 4 5 6 \n 7 8 9 의 9부분으로 이루어진 규칙이 계속된다.
 * 2) 매 5번째마다 공백이 입력되므로 이를 점화식의 재귀호출부로 삼는다.
 * 3) 저장할 공간이 1x1의 크기를 가진다면 *을 저장한다.
 */
public class WriteStar10_2447 {

  // 전역변수: * 또는 공백을 저장할 공간
  private static char[][] arr;

  public static void main(String[] args) {
    // 입력
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();

    arr = new char[n][n];

    // 재귀함수
    shootStar(0, 0, n, false);

    // 출력
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        sb.append(arr[i][j]);
      }
      sb.append('\n');
    }
    System.out.println(sb);

  }

  private static void shootStar(int x, int y, int n, boolean blank) {
    // blank라면 그 범위를 모두 공백으로 저장한 후 return
    if (blank) {
      for (int i = x; i < x + n; i++) {
        for (int j = y; j < y + n; j++) {
          arr[i][j] = ' ';
        }
      }
      return;
    }

    // 크기가 1이라면 *을 저장한 후 return
    if (n == 1) {
      arr[x][y] = '*';
      return;
    }

    // 현재 block을 3*3의 9부분으로 등분해서 재귀호출한다.
    int size = n / 3;
    int count = 0;
    for (int i = x; i < x + n; i += size) {
      for (int j = y; j < y + n; j += size) {
        count++;
        // 5번째는 공백으로 이루어져 있다.
        if (count == 5) {
          shootStar(i, j, size, true);
        } else {
          shootStar(i, j, size, false);
        }
      }
    }


  }
}
