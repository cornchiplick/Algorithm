import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
* chatGPT가 작성한 코드 테스트용
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        while (!input.equals(".")) {
            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;

            for (char c : input.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        isBalanced = false;
                        break;
                    }
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        isBalanced = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                isBalanced = false;
            }

            System.out.println(isBalanced ? "yes" : "no");
            input = br.readLine();
        }
    }
}
