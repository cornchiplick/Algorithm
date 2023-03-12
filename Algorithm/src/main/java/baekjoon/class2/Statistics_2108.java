package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 - 2108
 * 실버III - 통계학
 * 전략
 * 산술평균 : N개의 수들의 합을 N으로 나눈 값 : 소수 첫째자리에서 반올림
 * 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
 * 최빈값 : N개의 수들 중 가장 많이 나타나는 값 : 여러 최빈값이 있을 경우 두 번째로 작은 최빈값을 출력
 * 범위 : N개의 수들 중 최댓값과 최솟값의 차이 : [최댓값] - [최솟값]
 * 1) counting 정렬 기법 일부를 차용한다.
 * 2) 산술평균: sum을 미리 구하고 double 자료형에 유의하며 구한다.
 * 3) 중앙값: 입력받은 정수 개수의 절반을 넘어갈 때까지 index를 늘려가며 구한다.
 * 4) 최빈값: counting 배열에 최빈값의 빈도수가 있으므로, 최빈값의 최대빈도수가 1개 일 때, 2개 이상일 때 를 구분하여 구해준다.
 * 5) 범위: 입력받으며 미리 구해놓은 최댓값과 최솟값의 차를 구한다.
 */
public class Statistics_2108 {
  private static int sum = 0;
  private static int[] countArr = new int[8001];
  private static int max = Integer.MIN_VALUE;
  private static int min = Integer.MAX_VALUE;
  private static int median = 10000;
  private static int mode = 10000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int len = Integer.parseInt(br.readLine());

    // 정수 배열 입력
    for (int i = 0; i < len; i++) {
      int value = Integer.parseInt(br.readLine());
      sum += value;
      countArr[value + 4000]++;

      if (max < value) {
        max = value;
      }

      if (min > value) {
        min = value;
      }
    }

    StringBuilder sb = new StringBuilder();


    // 순회
    int count = 0;  // 중앙값 빈도 누적 수
    int mode_max = 0;  // 최빈값의 최댓값

    // 이전의 동일한 최빈값이 1번만 등장했을경우 true, 아닐경우 false
    boolean flag = false;

    for (int i = min + 4000; i <= max + 4000; i++) {

      if (countArr[i] > 0) {

        // 중앙값 찾기
        // 누적횟수가 전체 전체 길이의 절반에 못 미친다면
        if (count < (len + 1) / 2) {
          // i값의 빈도수를 count 에 누적
          count += countArr[i];
          median = i - 4000;
        }

        // 최빈값 찾기
        // 이전 최빈값보다 현재 값의 빈도수가 더 높을 경우
        if (mode_max < countArr[i]) {
          mode_max = countArr[i];
          mode = i - 4000;

          // 첫 등장이므로 true 로 변경
          flag = true;
        }
        // 이전 최빈값 최댓값과 동일한 경우면서 한 번만 중복되는 경우
        else if (mode_max == countArr[i] && flag) {
          mode = i - 4000;
          flag = false;
        }
      }
    }

    // 산술 평균
    int avg = (int) Math.round((double) sum / len);
    sb.append(avg).append("\n");

    // 중앙값
    sb.append(median).append("\n");

    // 최빈값
    sb.append(mode).append("\n");

    // 범위
    sb.append(max - min).append("\n");

    System.out.println(sb);

  }
}
