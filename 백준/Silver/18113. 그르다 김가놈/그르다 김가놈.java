import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 - 18113
 * 실버II - 그르다 김가놈
 * 전략
 * 1) 사용이 가능한 김밥들만 추려낸다.
 * 2) 사용이 가능한 김밥들을 잘라서 요구한 김밥조의 최대길이를 맞춘다.
 */
public class Main {

  // max설정
  private static long max = -1;
  private static long longest = 0;

  public static void main(String[] args) throws IOException {
    // 입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    List<Integer> list = new ArrayList<>();

    // 1차 솎아내기
    for (int i = 0; i < n; i++) {
      thinOutAndFindLongest(Integer.parseInt(br.readLine()), list, k);
    }
    br.close();

    // 최댓값 계산
    findMaxLength(list, m);

    // 출력
    System.out.println(max);

  }

  private static void findMaxLength(List<Integer> list, int m) {
    // list size가 0일 경우
    if (list.size() == 0) {
      return;
    }

    // 이분탐색 범위 설정
    long start = 1;
    long end = longest;

    // 이분탐색 수행
    while (start <= end) {
      long sum = 0;
      long mid = (start + end) / 2;

      // 김밥의 조각 수 계산
      for (int i = 0; i < list.size(); i++) {
        sum += list.get(i) / mid;
      }

      // 필요 개수보다 적을 경우, 더 짧게 자르기
      if (sum < m) {
        end = mid - 1;
      } else {
        // 필요 개수보다 많을 경우, 더 길게 자르기 + 최대길이를 구해야 하므로 우선 기록
        start = mid + 1;
        max = mid;
      }
    }
  }

  private static void thinOutAndFindLongest(int element, List<Integer> list, int k) {
    if (element > k && element < 2 * k) {
      list.add(element - k);
      longest = Math.max(longest, element);
    } else if (element > 2 * k) {
      list.add(element - 2 * k);
      longest = Math.max(longest, element);
    }
  }
}
