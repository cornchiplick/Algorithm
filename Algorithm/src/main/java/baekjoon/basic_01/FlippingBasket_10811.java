package baekjoon.basic_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 - 10811
 * 브론즈II - 바구니 뒤집기
 * 전략
 * 1) 기초적인 문제
 */
public class FlippingBasket_10811 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = i + 1;
    }

    int start;
    int end;
    int temp;
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      start = Integer.parseInt(st.nextToken()) - 1;
      end = Integer.parseInt(st.nextToken()) - 1;

      for (int j = 0; j <= (end - start) / 2; j++) {
        temp = arr[start + j];
        arr[start + j] = arr[end - j];
        arr[end - j] = temp;
      }

    }
    br.close();

    StringBuilder sb = new StringBuilder();
    for (int element : arr) {
      sb.append(element).append(' ');
    }

    System.out.println(sb);

  }
}
