package curriculum.sort;

import java.util.Arrays;

/**
 * 프로그래머스 - 정렬
 * lv2 - H-Index
 * 전략
 * 1) 논문 인용 배열을 내림차순으로 정렬한다. (여기서는 오름차순으로 정렬한 후, 뒤에서부터 세어주었다.)
 * 2) n번째로 인용수가 많은 논문의 인용수가 n보다 큰지 확인한다.
 * 3) 2)를 통과한 논문의 수가 몇 개인지 센다.
 */
public class HIndex {
  public static void main(String[] args) {
    int[] citations = {3, 0, 6, 1, 5};
    int result = 3;
    System.out.println(solution(citations));

  }

  public static int solution(int[] citations) {
    // 전략 1) 오름차순 정렬
    Arrays.sort(citations);

    int count = 0;

    // 전략 2), 3)
    for (int i = citations.length - 1, j = 1; i >= 0; i--, j++) {
      if (citations[i] < j) {
        break;
      }
      count++;
    }

    return count;
  }
}
