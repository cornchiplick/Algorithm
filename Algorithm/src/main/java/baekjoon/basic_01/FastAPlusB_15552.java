package baekjoon.basic_01;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 - 15552
 * 브론즈IV - 빠른 A+B
 * 전략
 * 1) 기초적인 반복문 문제
 */
public class FastAPlusB_15552 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());
    StringTokenizer st;

    for (int i = 0; i < t; i++) {
      st = new StringTokenizer(br.readLine());
      bw.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + "\n");

    }

    br.close();

    bw.flush();
    bw.close();

  }

}
