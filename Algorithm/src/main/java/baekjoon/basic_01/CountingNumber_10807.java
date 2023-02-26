package baekjoon.basic_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 - 10807
 * 브론즈V - 개수 세기
 * 전략
 * 1) 기초적인 문제
 */
public class CountingNumber_10807 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = new int[Integer.parseInt(br.readLine())];
    StringTokenizer st = new StringTokenizer(br.readLine());
    int num = Integer.parseInt(br.readLine());
    int temp;
    int count = 0;

    for (int i = 0; i < arr.length; i++) {
      temp = Integer.parseInt(st.nextToken());
      if (temp == num) {
        count++;
      }
    }

    System.out.println(count);

  }
}
