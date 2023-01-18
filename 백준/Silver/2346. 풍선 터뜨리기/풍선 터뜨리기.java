import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 백준 - 2346
 * 실버III - 풍선 터뜨리기
 * 전략
 * 1) ㅇㅇ
 */
public class Main {
  private static Deque<Balloon> dq = new ArrayDeque<>();
  private static StringBuilder sb = new StringBuilder();


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      dq.offerFirst(new Balloon(i, Integer.parseInt(st.nextToken())));
    }

    br.close();

    int next = 0;
    Balloon ans;

    while (!dq.isEmpty()) {
      if (next >= 0) {
        for (int i = 0; i < next - 1; i++) {
          dq.offerFirst(dq.pollLast());
        }
        ans = dq.pollLast();
      } else {
        for (int i = 0; i < -next - 1; i++) {
          dq.offerLast(dq.pollFirst());
        }
        ans = dq.pollFirst();
      }
      next = ans.pointer;
      sb.append(ans.index).append(' ');
    }

    System.out.println(sb);

  }

  static class Balloon {
    int index;
    int pointer;

    Balloon(int index, int pointer) {
      this.index = index;
      this.pointer = pointer;
    }

  }
}
