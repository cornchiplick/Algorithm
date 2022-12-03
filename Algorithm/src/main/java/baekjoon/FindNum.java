package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindNum {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 첫째, 둘째 줄 입력받기
    Integer[] a = setNumberLine(br);

    // 셋째, 넷째 줄 입력받기
    Integer[] b = setNumberLine(br);

    // a배열 정렬하기
    Arrays.sort(a);

    for (int i = 0; i < b.length; i++) {
      if (Arrays.binarySearch(a, b[i]) >= 0) {
        System.out.println(1);
      } else {
        System.out.println(0);
      }
    }

  }

  // 똑같은 형식의 입력 사이클을 두 번 하니까 만든 메서드
  private static Integer[] setNumberLine(BufferedReader br) throws IOException {
    // 첫째 줄 입력받기 :: num
    int num = Integer.parseInt(br.readLine());

    // 길이 num인 int 배열 생성
    Integer[] arr = new Integer[num];

    // 둘째 줄 입력받기 :: 공백으로 구분된 num개의 숫자들
    StringTokenizer line = new StringTokenizer(br.readLine(), " ");

    // 공백으로 구분된 num개의 숫자들을 a배열에 넣기
    for (int i = 0; i < num; i++) {
      arr[i] = Integer.parseInt(line.nextToken());
    }

    return arr;
  }

}
