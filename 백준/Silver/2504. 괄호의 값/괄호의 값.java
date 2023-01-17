import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준 - 2504
 * 실버I - 괄호의 값
 * 전략
 * 분배법칙 활용
 * 1) temp 기본값 1에 열때마다 *2 또는 *3 을 하고 스택에 push한다.
 * 2) 올바른 열고 닫는 괄호 쌍이라면 그 때까지의 temp 값을 answer에 추가한다. 이후 temp를 /2 또는 /3 해준다.
 * 3) 연속된 올바른 닫는괄호가 오면 /만 한다.
 * 4) 올바른 닫는 괄호라면 pop한다.
 * 5) 이를 식의 처음부터 끝까지 반복한다.
 */
public class Main {

  private static Stack<Integer> st = new Stack<>();
  private final static int INCORRECT_EQUATION = 0;
  private final static int SMALL_BRACKET_NUMBER = 2;
  private final static int BIG_BRACKET_NUMBER = 3;

  public static void main(String[] args) throws IOException {
    // 입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    // 계산 및 출력
    System.out.println(calculate(str));

  }

  private static int calculate(String str) {
    // 분배법칙 적용할 계수 임시저장
    int temp = 1;

    // 답
    int answer = 0;

    for (int i = 0; i < str.length(); i++) {
      // 식의 i번째 문자 판별 및 계산
      char c = str.charAt(i);
      switch (c) {
        case '(': {
          temp *= SMALL_BRACKET_NUMBER;
          st.push(SMALL_BRACKET_NUMBER);
          break;
        }

        case ')': {
          if (st.isEmpty() || st.peek() != SMALL_BRACKET_NUMBER) {
            return INCORRECT_EQUATION;
          } else if (str.charAt(i - 1) == '(') {
            answer += temp;
          }
          temp /= SMALL_BRACKET_NUMBER;
          st.pop();
          break;
        }

        case '[': {
          temp *= BIG_BRACKET_NUMBER;
          st.push(BIG_BRACKET_NUMBER);
          break;
        }

        case ']': {
          if (st.isEmpty() || st.peek() != BIG_BRACKET_NUMBER) {
            return INCORRECT_EQUATION;
          } else if (str.charAt(i - 1) == '[') {
            answer += temp;
          }
          temp /= BIG_BRACKET_NUMBER;
          st.pop();
          break;
        }
      }
    }

    // stack이 비어있어야 올바른 식이다.
    if (st.size() != 0) {
      return INCORRECT_EQUATION;
    }

    return answer;
  }
}
