package baekjoon.basic_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 - 25304
 * 브론즈V - 영수증
 * 전략
 * 1) 기초적인 반복문 문제
 */
public class Receipt_25304 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int x = Integer.parseInt(br.readLine());
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st;
    int price;
    int cnt;
    int sum = 0;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      price = Integer.parseInt(st.nextToken());
      cnt = Integer.parseInt(st.nextToken());

      sum += price * cnt;
    }

    if (x == sum) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }

  }
}
