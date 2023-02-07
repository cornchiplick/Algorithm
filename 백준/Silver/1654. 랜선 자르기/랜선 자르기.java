import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 - 1654
 * 실버II - 랜선 자르기
 * 전략
 * 1) 가장 짧게 자르는 0부터, 가장 긴 길이를 가지는 원소의 길이만큼의 범위에서 이진탐색을 시행한다.
 */
public class Main {

  // max설정
  private static long max = 0;

  public static void main(String[] args) throws IOException {
    // 입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int k = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    int[] bundle = new int[k];

    for (int i = 0; i < k; i++) {
      bundle[i] = Integer.parseInt(br.readLine());
    }
    br.close();

    // 정렬
    Arrays.sort(bundle);

    // 최댓값 계산
    findMaxLength(bundle, n);

    // 출력
    System.out.println(max);
  }

  private static void findMaxLength(int[] bundle, int n) {
    // 이분탐색 범위 설정
    long start = 0;
    long end = bundle[bundle.length - 1];

    // 이분탐색 수행
    while (start <= end) {
      long sum = 0;
      // 0으로 나누는 경우 제외
      long mid = start + (end - start) / 2;
      if (mid == 0) {
        mid = 1;
      }

      // lan선의 조각 수 계산
      for (int i = 0; i < bundle.length; i++) {
        sum += bundle[i] / mid;
      }

      // 필요 개수보다 적을 경우, 더 짧게 자르기
      if (sum < n) {
        end = mid - 1;
      } else {
        // 필요 개수보다 많을 경우, 더 길게 자르기 + 최대길이를 구해야 하므로 우선 기록
        start = mid + 1;
        max = mid;
      }
    }
  }
}
