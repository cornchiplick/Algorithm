import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준 - 17608
 * 브론즈II - 막대기
 * 전략
 * 1) 스택에 왼쪽막대기부터 집어넣는다.
 * 2) 스택에서 꺼내면서 최댓값을 갱신한다.
 * 3) 최댓값보다 큰 길이의 막대기의 개수만 카운트한다.
 */
public class Main {
  public static void main(String[] args) throws IOException {
    // 입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < n; i++) {
      st.push(Integer.parseInt(br.readLine()));
    }

    // 개수, 최대값 임시저장
    int count = 0;
    int max = 0;
    
    // 최대값 갱신 및 count
    while (!st.isEmpty()) {
      if (st.peek() > max) {
        max = st.peek();
        count++;
      }
      st.pop();
    }

    // 출력
    System.out.println(count);

  }
}
