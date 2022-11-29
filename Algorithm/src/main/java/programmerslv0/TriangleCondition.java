package programmerslv0;

public class TriangleCondition {

  public static void main(String[] args) {
    int[] sides = {11, 7};
    System.out.println(solution(sides));

  }

  public static int solution(int[] sides) {
    int answer = 0;
    int max;
    int min;
    if (sides[0] <= sides[1]) {
      max = sides[1];
      min = sides[0];
    } else {
      max = sides[0];
      min = sides[1];
    }

    for (int i = 1; i <= max; i++) {
      if (min + i > max) {
        answer++;
      }
    }

    answer += min-1;

    return answer;
  }
}
