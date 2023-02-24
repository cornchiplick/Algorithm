package baekjoon.greedy_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 - 11047
 * 실버IV - 동전 0
 * 전략
 * 1) 오름차순으로 동전의 종류가 주어지기 때문에
 * 2) 정렬할 필요도 없이 큰 수부터 시작해서 k를 나누어주면 된다.
 */
public class Coin0_11047 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    Integer[] list = new Integer[n];
    for (int i = 0; i < n; i++) {
      list[i] = Integer.parseInt(br.readLine());
    }
    br.close();

    int result = 0;
    for (int i = list.length - 1; i >= 0; i--) {
      if (k == 0) {
        break;
      }
      if (list[i] <= k) {
        result += k / list[i];
        k %= list[i];
      }
    }

    System.out.println(result);

  }
}
