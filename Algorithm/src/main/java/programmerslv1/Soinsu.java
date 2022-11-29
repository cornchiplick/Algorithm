package programmerslv1;

import java.util.ArrayList;

public class Soinsu {
  public static void main(String[] args) {


    for (int i = 0; i < solution(12).length; i++) {
      System.out.println(solution(12)[i]);
    }
  }

  public static int[] solution(int n) {
    ArrayList arr = new ArrayList();
    int i = 2;
    while (n != 1) {
      if (n%(i*i) == 0) {
        n /= i;
        continue;
      }
      if (n%i == 0) {
        n /= i;
        arr.add(i);
        i++;
      } else {
        i++;
      }

    }

    int[] answer = new int[arr.size()];

    for (int j = 0; j < arr.size(); j++) {
      answer[j] = (int) arr.get(j);
    }

    return answer;
  }
}
