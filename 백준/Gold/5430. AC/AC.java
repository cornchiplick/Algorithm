import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 백준 - 5430
 * 골드V - AC
 * 전략
 * 1) 문자열로 주어진 배열을 파싱한다.
 * 2) 주어진 함수의 배열대로 계산을 처리한다.
 * 3) 그 과정에서 error가 나올 수 있는 경우를 모두 처리한다.
 */
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      String fn = br.readLine();
      int len = Integer.parseInt(br.readLine());
      String nums = br.readLine();
      System.out.println(calculate(fn, len, nums));
    }
    br.close();

  }

  private static String calculate(String fn, int len, String nums) {
    String isError = fn.replaceAll("R", "");
    nums = nums.substring(1, nums.length() - 1);

    // error 출력 케이스
    if (nums.length() == 0 && isError.equals("")) {
      return "[]";
    } else if (nums.length() == 0) {
      return "error";
    }

    // parsing
    int[] numbers = parse(nums);

    // error 출력 케이스
    if (len != numbers.length || isError.length() > numbers.length) {
      return "error";
    }

    // 덱에 입력
    Deque<Integer> dq = new ArrayDeque<>();

    for (int i = 0; i < numbers.length; i++) {
      dq.offerLast(numbers[i]);
    }

    // 뒤집히는 경우 체크
    boolean reverse = false;

    // 계산
    for (int i = 0; i < fn.length(); i++) {
      char command = fn.charAt(i);
      switch (command) {
        case 'R': {
          reverse = !reverse;
          break;
        }
        case 'D': {
          if (reverse) {
            dq.pollLast();
          } else {
            dq.pollFirst();
          }
          break;
        }
      }
    }

    if (reverse) {
      Deque<Integer> reversed = new ArrayDeque<>();
      for (Integer element : dq) {
        reversed.offerFirst(element);
      }
      return reversed.toString().replaceAll(" ", "");
    } else {
      return dq.toString().replaceAll(" ", "");
    }
  }

  private static int[] parse(String nums) {
    String[] temp = nums.split(",");
    int[] answer = new int[temp.length];

    if (answer.length != 0) {
      for (int i = 0; i < answer.length; i++) {
        answer[i] = Integer.parseInt(temp[i]);
      }
    }

    return answer;
  }
}