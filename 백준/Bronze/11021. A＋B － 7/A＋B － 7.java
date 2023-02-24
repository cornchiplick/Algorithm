import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 - 11021
 * 브론즈V - A+B-7
 * 전략
 * 1) 기초적인 반복문 문제
 */
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < t; i++) {
      st = new StringTokenizer(br.readLine());
      sb.append("Case #").append(i+1).append(": ");
      sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append('\n');
    }
    br.close();

    System.out.println(sb);

  }
}
