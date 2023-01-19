import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준 - 10799
 * 실버II - 쇠막대기
 * 전략
 * 1) 쇠막대기를 추가할 때마다 두께를 1 추가한다.
 * 2) 쇠막대기를 자를 때마다 두께만큼 더한다
 * 3) 레이저가 아닌 막대의 끝이라면 answer에 1추가한다.
 */
public class Main {
  private static final int SMALL_BRACKET_NUMBER = 2;
  private static Stack<Integer> st = new Stack<>();

  public static void main(String[] args) throws IOException {
// 입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    // 계산 및 출력
    System.out.println(calculate(str));

  }

  private static int calculate(String str) {
    // 답
    int answer = 0;

    // 두께
    int temp = 0;

    for (int i = 0; i < str.length(); i++) {
      // 식의 i번째 문자 판별 및 계산
      char c = str.charAt(i);
      switch (c) {
        case '(': {
          temp++;
          st.push(SMALL_BRACKET_NUMBER);
          break;
        }

        case ')': {
          temp--;
          if (str.charAt(i - 1) == '(') {
            answer += temp;
          } else if (str.charAt(i - 1) == ')') {
            answer++;
          }
          st.pop();
          break;
        }
      }
    }

    return answer;
  }
}
