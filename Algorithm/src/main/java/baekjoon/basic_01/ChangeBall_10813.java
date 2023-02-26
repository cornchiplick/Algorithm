package baekjoon.basic_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 - 10813
 * 브론즈II - 공 바꾸기
 * 전략
 * 1) 기초적인 문제
 */
public class ChangeBall_10813 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = i + 1;
    }

    int a;
    int b;
    int temp;

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken()) - 1;
      b = Integer.parseInt(st.nextToken()) - 1;

      temp = arr[a];
      arr[a] = arr[b];
      arr[b] = temp;
    }

    StringBuilder sb = new StringBuilder();
    for (int element : arr) {
      sb.append(element).append(' ');
    }

    System.out.println(sb);
  }
}
