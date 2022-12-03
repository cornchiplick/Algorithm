import java.util.*;

class Solution {
public int[] solution(int[] numlist, int n) {
    Integer[] sorted = new Integer[numlist.length];

    for (int i = 0; i < numlist.length; i++) {
      sorted[i] = numlist[i] - n;
    }

    Arrays.sort(sorted, (Integer o1, Integer o2) -> {
      if (Math.abs(o1) == Math.abs(o2)) {
        return o2 - o1;
      } else {
        return Math.abs(o1) - Math.abs(o2);
      }
    });

    int[] answer = new int[sorted.length];
    for (int i = 0; i < sorted.length; i++) {
      answer[i] = sorted[i] + n;
    }

    return answer;
  }
}