import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 11582 : silver IV - 치킨 TOP N
 * 병합 정렬(Merge Sort)의 변형문제이다.
 * 기본적으로 병합정렬을 구현하되
 * 중간 단계까지만 진행하여 그 진행상황을 출력한다.
 */
public class Main {
  private static int[] sorted;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] arr = new int[Integer.parseInt(br.readLine())];
    sorted = new int[arr.length];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int k = Integer.parseInt(br.readLine());

    br.close();

    mergeSort(arr, 0, arr.length - 1, k);

    StringBuilder sb = new StringBuilder();
    for (int e : arr) {
      sb.append(e).append(" ");
    }

    System.out.println(sb);

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

  private static void mergeSort(int[] arr, int m, int n, int k) {
    // 크기가 1보다 큰 경우
    if (m < n) {
      int middle = (m + n) / 2;
      mergeSort(arr, m, middle, k);
      mergeSort(arr, middle + 1, n, k);
      // 정렬해야할 배열 길이가 (arr.length / 2) 가 될 때까지만 정렬을 수행한다.
      if (n - m + 1 <= arr.length / k) {
        merge(arr, m, middle, n);
      }
    }
  }
}
