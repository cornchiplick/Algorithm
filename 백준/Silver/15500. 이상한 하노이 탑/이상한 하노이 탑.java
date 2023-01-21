import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 백준 - 15500
 * 실버II - 이상한 하노이 탑
 * 전략
 * 1) 처음에 모든 원판은 1번 장대에 들어있다.
 * 2) 원판의 현재위치를 position배열을 통해 모두 추적한다.
 * 3) 가장 크기가 큰 원판부터 3번 장대로 옮기고, 해당 크기가 아닌 원판은 현재 장대가 아닌 다른 장대로 옮긴다.
 * 4) 이 이동 과정을 모두 StringBuilder에 기록하고, loop를 돌 때마다 count를 증가시킨다.
 */
public class Main {
  public static void main(String[] args) throws IOException {
    // 입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    
    // 두 장대
    StringTokenizer st = new StringTokenizer(br.readLine());
    Stack<Integer> first = new Stack<>();
    for (int i = 0; i < n; i++) {
      first.push(Integer.parseInt(st.nextToken()));
    }

    Stack<Integer> second = new Stack<>();
    
    // 원판의 현재 위치
    int[] position = new int[n + 1];
    Arrays.fill(position, 1);

    // 현재 찾고자 하는 원판 크기
    int index = n;
    
    int count = 0;
    StringBuilder sb = new StringBuilder();

    // 원판 이동 루프
    while (index != 0) {
      if (position[index] == 1) {
        if (first.peek() == index) {
          first.pop();
          sb.append(1).append(' ').append(3).append('\n');
          index--;
        } else {
          position[first.peek()] = 2;
          sb.append(1).append(' ').append(2).append('\n');
          second.push(first.pop());
        }
      } else {
        if (second.peek() == index) {
          second.pop();
          sb.append(2).append(' ').append(3).append('\n');
          index--;
        } else {
          position[second.peek()] = 1;
          sb.append(2).append(' ').append(1).append('\n');
          first.push(second.pop());
        }
      }

      count++;
    }

    System.out.println(count);
    System.out.println(sb);

  }
}
