package programmers.applytest;

import java.util.Scanner;

public class Star {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        sb.append("*");
      }
      sb.append('\n');
    }
    String str = sb.substring(0, sb.length() - 1);

    System.out.println(str);
  }
}
