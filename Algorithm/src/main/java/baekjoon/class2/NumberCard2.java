package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 두 카드 배열 입력받기
    int[] own = inputCard(br); // 가지고 있는 카드들
    int[] taken = inputCard(br); // 그에게 주어진 카드들

    // 가지고 있는 카드 오름차순 정렬하기
    Arrays.sort(own);

    StringBuilder sb = new StringBuilder();

    for (int element : taken) {
      // 몇개있는지 세기 + 공백
      sb.append(findLength(own, element)).append(" ");
    }

    // 몇개있는지 적혀 있는 sb의 맨 끝의 공백만 제거하고 출력하기
    System.out.println(sb.toString().substring(0, sb.toString().length()-1));

  }

  private static int findLength(int[] own, int element) {
    int idx = Arrays.binarySearch(own, element);

    if (idx >= 0) {
      int startPoint = searchLowerIndex(element, own);
      int endPoint = searchUpperIndex(element, own);
      return endPoint-startPoint;
    } else {
      return 0;
    }
  }

  private static int searchLowerIndex(int element, int[] own) {
    int startPoint = 0;
    int endPoint = own.length;

    while (startPoint < endPoint) {
      int mid = startPoint + (endPoint-startPoint) / 2;

      if (element <= own[mid]) {
        endPoint = mid;
      } else {
        startPoint = mid + 1;
      }
    }

    return startPoint;
  }

  private static int searchUpperIndex(int element, int[] own) {
    int startPoint = 0;
    int endPoint = own.length;

    while (startPoint < endPoint) {
      int mid = startPoint + (endPoint-startPoint) / 2;

      if (element < own[mid]) {
        endPoint = mid;
      } else {
        startPoint = mid + 1;
      }
    }

    return startPoint;
  }

  // 똑같은 입력을 두 번 받으니까 만든 메서드
  private static int[] inputCard(BufferedReader br) throws IOException {
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    return arr;
  }
}
