package baekjoon.curriculum.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OrganizeBigNumber_18511 {
  public static int max = 0;
  public static int n;

  public static void main(String[] args) throws IOException {
    // 입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    int[] k = new int[Integer.parseInt(st.nextToken())];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < k.length; i++) {
      k[i] = Integer.parseInt(st.nextToken());
    }

    // n이하의 자연수 중 k의 원소로만 구성된 가장 큰 수 구하기
    int depth = 0;
    findBigNumber(0, depth, k);

    System.out.println(max);

  }

  private static void findBigNumber(int num, int depth, int[] k) {
    if (depth > String.valueOf(n).length()) {
      return;
    }

    for (int i = 0; i < k.length; i++) {
      int number = num * 10 + k[i];
      if (number <= n) {
        max = Math.max(number, max);
      }
      findBigNumber(number, depth + 1, k);
    }

  }
}
