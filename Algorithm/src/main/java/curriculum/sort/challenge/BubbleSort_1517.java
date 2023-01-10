package curriculum.sort.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 - 1517
 * 플래티넘V - 버블 소트
 * 전략
 * 1) 실제로 버블소트를 구현하여 카운팅하면 시간초과가 난다.
 * 2) 그러므로 병합정렬을 사용하여 얼마나 swap 해야 하는지 부분적으로 합산한다.
 * 3) 더 작은 수가 우측에 있을 경우 좌측으로 얼마나 이동해야 하는지를 계산하여 최종 count변수에 추가한다.
 * 4) 이 때, 최종 count는 문제에서 주어진 조건에 따라 (50만)^2인 2500억 까지 증가할 수 있으므로 int변수로는 오버플로우가 일어날 수 있다.
 * 참고 : https://velog.io/@solser12/%EB%B0%B1%EC%A4%80-1517-%EB%B2%84%EB%B8%94-%EC%86%8C%ED%8A%B8-JAVA
 */
public class BubbleSort_1517 {
  private static int[] sorted;
  private static long count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = new int[Integer.parseInt(br.readLine())];
    sorted = new int[arr.length];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    mergeSort(arr, 0, arr.length - 1);

    System.out.println(count);

  }


  private static void merge(int[] arr, int m, int middle, int n) {
    int i = m;
    int j = middle + 1;
    int k = m;

    // 작은 데이터부터 삽입
    while (i <= middle && j <= n) {
      if (arr[i] <= arr[j]) {
        sorted[k] = arr[i];
        i++;
      } else {
        sorted[k] = arr[j];
        j++;
        count += middle - i + 1;
      }
      k++;
    }

    // 남은 데이터 처리
    if (i > middle) {
      for (int p = j; p <= n; p++) {
        sorted[k] = arr[p];
        k++;
      }
    } else {
      for (int p = i; p <= middle; p++) {
        sorted[k] = arr[p];
        k++;
      }
    }

    // 정렬된 배열을 삽입
    for (int p = m; p <= n; p++) {
      arr[p] = sorted[p];
    }

  }

  private static void mergeSort(int[] arr, int m, int n) {
    // 크기가 1보다 큰 경우
    if (m < n) {
      int middle = (m + n) / 2;
      mergeSort(arr, m, middle);
      mergeSort(arr, middle + 1, n);
      merge(arr, m, middle, n);
    }
  }
}
