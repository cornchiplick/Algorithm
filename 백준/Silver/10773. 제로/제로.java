import java.util.Scanner;
import java.util.Stack;

/**
 * 백준 - 10773
 * 실버IV - 제로
 * 전략
 * 1) 스택에 올바른 수만 남기기
 * 2) 올바른 수들을 모두 더하기
 */
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    
    Stack<Integer> st = new Stack<Integer>();

    // 스택 형태이므로 push pop 이용해서 올바른 수만 stack에 남기기
    for (int i = 0; i < n; i++) {
      int temp = sc.nextInt();
      if (temp != 0) {
        st.push(temp);
      } else {
        st.pop();
      }
    }

    // stack의 모든 숫자 더하기
    int answer = 0;
    for (Integer num : st) {
      answer += num;
    }

    // 출력
    System.out.println(answer);

  }
}
