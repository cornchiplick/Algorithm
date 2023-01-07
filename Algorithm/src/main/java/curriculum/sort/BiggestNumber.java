package curriculum.sort;

import java.util.Arrays;

/**
 * 프로그래머스 - 정렬
 * lv2 - 가장 큰 수
 * 전략
 * 1) 숫자 두 개를 비교할 때 이어붙여본다.
 * 2) AB순서와 BA순서를 비교해서 더 큰숫자가 되는 순열에서 앞의 수가 더 큰수다
 */
public class BiggestNumber {
  public static void main(String[] args) {
    int[] numbers1 = {6, 10, 2};
    String result1 = "6210";
    System.out.println("case1: " + solution(numbers1));

    int[] numbers2 = {3, 30, 34, 5, 9};
    String result2 = "9534330";
    System.out.println("case2: " + solution(numbers2));

  }

  public static String solution(int[] numbers) {
    // 숫자 배열을 문자열로 변환
    String[] strArr = new String[numbers.length];
    for (int i = 0; i < numbers.length; i++) {
      strArr[i] = String.valueOf(numbers[i]);
    }

    Arrays.sort(strArr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

    if (strArr[0].equals("0")) {
      return "0";
    }

    StringBuilder sb = new StringBuilder();
    for (String e : strArr) {
      sb.append(e);
    }

    return sb.toString();
  }
}
