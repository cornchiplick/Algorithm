import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

/**
 * 백준 - 1874
 * 실버II - 스택 수열
 * 전략
 * 1) 주어진 입력을 순서를 표기하여(HashMap 이용) 받는다.
 * 2) map을 순회하며 stack에 map객체의 value와 같아질 때까지 push한다.
 * 3) stack의 top과 map의 value가 같다면 pop한다.
 * 3) 그렇지 않다면 불가능한 경우이므로 "NO"를 출력하게 한다.
 */
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 1; i <= n; i++) {
      map.put(i,Integer.parseInt(br.readLine()));
    }

    System.out.println(isPossible(map));
  }

  private static String isPossible(HashMap<Integer, Integer> map) {
    StringBuilder sb = new StringBuilder();
    Stack<Integer> st = new Stack<>();
    int cursor = 1;

    for (int i = 1; i <= map.size(); i++) {
      while (cursor <= map.get(i)) {
        st.push(cursor);
        sb.append("+\n");
        cursor++;
      }

      if (Objects.equals(st.peek(), map.get(i))) {
        st.pop();
        sb.append("-\n");
      } else {
        return "NO";
      }
    }

    return sb.toString();
  }
}
