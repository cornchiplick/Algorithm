import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      checkBrackets(br.readLine());
    }

  }

  static void checkBrackets(String s) {
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        st.add(1);
      } else {
        if (st.size() != 0) {
          st.pop();
        } else {
          System.out.println("NO");
          return;
        }
      }
    }

    if (st.size() != 0) {
      System.out.println("NO");
      return;
    }
    System.out.println("YES");
    return;
  }
}
