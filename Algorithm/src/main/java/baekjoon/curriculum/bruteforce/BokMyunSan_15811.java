package baekjoon.curriculum.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BokMyunSan_15811 {
  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
    String first = st.nextToken();
    String second = st.nextToken();
    String third = st.nextToken();

    int[] num = new int[10];
    for (int i = 0; i < num.length; i++) {
      num[i] = i;
    }


  }
}
