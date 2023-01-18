import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 - 15565
 * 실버I - 귀여운 라이언
 * 전략
 * 1) slide window 쓸 것.
 * 2) 라이언 인형인 것만 index값을 덱에 넣는다.
 * 3) 모든 인형의 개수가 k보다 작다면 -1을 출력한다.
 * 4) 그렇지 않다면 k개의 라이언 인형의 처음과 끝 인덱스 값으로 부분집합의 길이를 구한다.
 */
public class Main {
  private static int min;

  public static void main(String[] args) throws IOException {
    // 입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    // 라이언 인형인 것만 index를 list에 추가
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (Integer.parseInt(st.nextToken()) == 1) {
        list.add(i);
      }
    }

    // 계산
    cntLion(k, n, list);

    // 출력
    System.out.println(min);

  }

  private static void cntLion(int k, int n, List<Integer> list) {
    int start;
    int end;

    if (list.size() < k) {
      min = -1;
      return;
    }

    // min의 최대값 + 1
    min = n + 1;

    // 덱에 k개의 라이언 인형 추가
    Deque<Integer> dq = new LinkedList<>();
    for (int i = 0; i < k; i++) {
      dq.offerFirst(list.get(i));
    }

    // 초기값 세팅
    start = dq.peekLast();
    end = dq.peekFirst();
    min = Math.min(min, end - start + 1);

    for (int i = k; i < list.size(); i++) {
      dq.offerFirst(list.get(i));
      dq.pollLast();

      start = dq.peekLast();
      end = dq.peekFirst();

      min = Math.min(min, end - start + 1);
    }

  }
}
