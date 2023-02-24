package baekjoon.recurrence_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 - 24060
 * 실버VI - 알고리즘 수업 - 병합 정렬 1
 * 단계별로 풀어보기 - 재귀
 * 재귀함수 설계능력이 부족하다고 판단하여 진행하는 단계별로 풀어보기 - 재귀 편 : 반드시 재귀함수를 사용하여 풀 것이다.
 * 전략
 * 1) MergeSort를 구현한다.
 * 2) MergeSort중 sorted배열에 값을 저장할 때마다 k번째 저장인지 체크한 후, 저장된 값을 전역변수 saved에 저장한다.
 * 3) k번째 저장이 일어나지 않았다면 -1을 출력한다.
 */
public class MergeSort1_24060 {
  private static int[] sorted;
  private static int count = 0;
  private static int k;
  private static int saved = -1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    sorted = new int[n];
    k = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    br.close();

    mergeSort(arr, 0, arr.length - 1);

    System.out.println(saved);

  }

  private static void merge(int[] arr, int start, int middle, int end) {
    int p = start;
    int q = middle + 1;
    int r = start;

    // 작은 데이터부터 삽입
    while (p <= middle && q <= end) {
      if (arr[p] <= arr[q]) {
        count++;
        if (count == k) {
          saved = arr[p];
        }
        sorted[r++] = arr[p++];
      } else {
        count++;
        if (count == k) {
          saved = arr[q];
        }
        sorted[r++] = arr[q++];
      }
    }

    // 왼쪽이 남았을 경우
    while (p <= middle) {
      count++;
      if (count == k) {
        saved = arr[p];
      }
      sorted[r++] = arr[p++];
    }

    // 오른쪽이 남았을 경우
    while (q <= end) {
      count++;
      if (count == k) {
        saved = arr[q];
      }
      sorted[r++] = arr[q++];
    }

    // 원래 배열로 데이터 이관
    for (int i = start; i <= end; i++) {
      arr[i] = sorted[i];
    }

  }

  private static void mergeSort(int[] arr, int start, int end) {
    if (start < end) {
      int middle = (start + end) / 2;
      mergeSort(arr, start, middle);
      mergeSort(arr, middle + 1, end);
      merge(arr, start, middle, end);
    }
  }
}
