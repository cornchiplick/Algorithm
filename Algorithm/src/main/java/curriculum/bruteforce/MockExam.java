package curriculum.bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockExam {
  public static void main(String[] args) {
    int[] answers = {1, 3, 2, 4, 2};
    int[] result = {1, 2, 3};
    System.out.println(Arrays.toString(solution(answers)));

  }

  public static int[] solution(int[] answers) {
    // 수포자들이 찍는 패턴
    int[] count = new int[3];
    int[] first = {1, 2, 3, 4, 5};
    int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    // 찍은 답이 맞았는지 확인한 후 맞은 개수 세기
    for (int i = 0; i < answers.length; i++) {
      if (answers[i] == first[i % 5]) {
        count[0]++;
      }

      if (answers[i] == second[i % 8]) {
        count[1]++;
      }

      if (answers[i] == third[i % 10]) {
        count[2]++;
      }
    }

    // 최대로 맞은 개수와 같은지 확인하여 1부터 순차적으로 출력
    int max = Math.max(Math.max(count[0], count[1]), count[2]);
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < count.length; i++) {
      if (max == count[i]) {
        list.add(i + 1);
      }
    }

    int[] answer = new int[list.size()];
    for (int i = 0; i < answer.length; i++) {
      answer[i] = list.get(i);
    }

    return answer;
  }
}
