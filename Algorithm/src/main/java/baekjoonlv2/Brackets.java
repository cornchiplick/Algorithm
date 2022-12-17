package baekjoonlv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Brackets {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      checkBrackets(br.readLine());
    }

  }

  static void checkBrackets(String s) {
    Stack<Integer> st = new Stack<>();

    // 스택에 '(' 면 1추가, ')' 면 추가한것 빼기
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        st.add(1);
      } else {
        // 비어있지 않아야 뺄 수 있다.
        if (st.size() != 0) {
          st.pop();
        } else {
          // 비어있는데 빼려고 하면 즉시 return, NO
          System.out.println("NO");
          return;
        }
      }
    }

    // 넣을거 넣고 뺄거 다 빼고 난 후에 최종 size가 0이면 YES
    if (st.size() != 0) {
      System.out.println("NO");
      return;
    }
    System.out.println("YES");
    return;
  }
}
