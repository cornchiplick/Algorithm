package baekjoon.greedy_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 - 1541
 * 실버II - 잃어버린 괄호
 * 전략
 * 1) 가장 처음에 나오는 -기호의 앞부분은 모두 더한다.
 * 2) 그 이후 부분에 나오는 숫자는 모두 뺀다.
 * 3) 가장 처음 나오는 -기호를 기준으로 각 부분에 나오는 숫자의 합을 구하는 메서드를 구현하여 A-B의 식을 계산한다.
 * 4) -기호가 존재하지 않는다면 모든 숫자를 더해서 return한다.
 */
public class LostBracket_1541 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    br.close();

    int index = str.indexOf("-");
    if (index >= 0) {
      String plus = str.substring(0, index);
      String minus = str.substring(index + 1, str.length());
      System.out.println(parseStatement(plus) - parseStatement(minus));
    } else {
      System.out.println(parseStatement(str));
    }


  }

  private static int parseStatement(String str) {
    // 끝 부분에 숫자가 아닌 임의의 문자 추가
    str += "+";

    int number = 0;
    StringBuilder temp = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      // 숫자라면 temp에 추가
      if (Character.isDigit(str.charAt(i))) {
        temp.append(str.charAt(i));
      } else {
        // 숫자가 아니라면 지금까지의 temp를 숫자로 변환하여 더하고 temp를 초기화
        number += Integer.parseInt(temp.toString());
        temp.setLength(0);
      }
    }

    return number;
  }
}
