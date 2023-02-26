package baekjoon.basic_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 - 10810
 * 브론즈III - 공 넣기
 * 전략
 * 1) 기초적인 문제
 */
public class PuttingBall_10810 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    int start;
    int end;
    int num;

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      start = Integer.parseInt(st.nextToken());
      end = Integer.parseInt(st.nextToken());
      num = Integer.parseInt(st.nextToken());

      for (int j = start - 1; j < end; j++) {
        arr[j] = num;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int element : arr) {
      sb.append(element).append(' ');
    }
    System.out.println(sb);

  }
}
