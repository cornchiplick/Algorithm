package curriculum.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack1 {
  static Stack st = new Stack();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());


    for (int i = 0; i < N; i++) {
      behavior(br);
    }

    br.close();

  }

  private static void behavior(BufferedReader br) throws IOException {
    String command = br.readLine();

    switch (command) {
      case "pop": {
        if (st.isEmpty()) {
          System.out.println(-1);
          break;
        }
        System.out.println(st.pop());
        break;
      }

      case "size": {
        System.out.println(st.size());
        break;
      }

      case "empty": {
        if (st.isEmpty()) {
          System.out.println(1);
        } else {
          System.out.println(0);
        }
        break;
      }

      case "top": {
        if (st.isEmpty()) {
          System.out.println(-1);
          break;
        }
        System.out.println(st.peek());
        break;
      }

      default: {
        st.push(Integer.parseInt(command.substring(5)));
      }

    }

  }
}
