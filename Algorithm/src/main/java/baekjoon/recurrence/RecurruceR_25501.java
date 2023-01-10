package baekjoon.recurrence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 - 25501
 * 브론즈II - 재귀의 귀재
 * 단계별로 풀어보기 - 재귀
 * 재귀함수 설계능력이 부족하다고 판단하여 진행하는 단계별로 풀어보기 - 재귀 편 : 반드시 재귀함수를 사용하여 풀 것이다.
 * 전략
 * 1) recursion함수의 결과값과 몇 번 호출되었는지 셈한 두 요소를 갖는 정수배열을 리턴하도록 isPalindrome함수를 변형하였다.
 * 2) recursion함수의 결과값을 answer[0]에, 호출횟수를 카운팅하는 전역변수 count의 값을 answer[1]에 할당하여 return하고,
 *    전역변수 count를 매 문자열마다 0으로 초기화한다.
 */
public class RecurruceR_25501 {
  private static int count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inspect = new String[Integer.parseInt(br.readLine())];

    for (int i = 0; i < inspect.length; i++) {
      inspect[i] = br.readLine();
    }

    StringBuilder sb = new StringBuilder();
    for (String e : inspect) {
      count = 0;
      char[] arr = e.toCharArray();
      int[] answer = isPalindrome(arr);
      sb.append(answer[0]).append(" ").append(answer[1]).append('\n');
    }

    System.out.println(sb);

  }

  private static int[] isPalindrome(char[] arr) {
    int[] answer = new int[2];
    answer[0] = recursion(arr, 0, arr.length - 1);
    answer[1] = count;
    return answer;
  }

  private static int recursion(char[] arr, int start, int end) {
    count++;
    if (start >= end) {
      return 1;
    } else if (arr[start] != arr[end]) {
      return 0;
    } else {
      return recursion(arr, start + 1, end - 1);
    }

  }


}
