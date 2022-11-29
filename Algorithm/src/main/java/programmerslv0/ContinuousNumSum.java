package programmerslv0;

import java.util.ArrayList;

public class ContinuousNumSum {

  public static void main(String[] args) {

    int num = 4;
    int total = 14;
    for (int i = 0; i < solution(4,14).length; i++) {
      System.out.println(solution(4, 14)[i]);
    }
    int[] result = {2, 3, 4, 5};

  }

  public static int[] solution(int num, int total) {
    int[] answer = new int[num];
    ArrayList<Integer> arr = new ArrayList<>();

    if (total%num == 0) {
      for (int i = (total/num)-(num/2); i <= (total/num)+(num/2); i++) {
        arr.add(i);
      }
    } else {
      for (int i = (total/num)-(num/2)+1; i <= (total/num)+(num/2); i++) {
        arr.add(i);
      }
    }

    for (int i = 0; i < arr.size(); i++) {
      answer[i] = arr.get(i);
    }

    return answer;
  }
}
