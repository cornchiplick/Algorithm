package programmers.programmerslv0;

public class LimitedDouble {

  public static void main(String[] args) {
    int a1 = 11;
    int b1 = 22;
    System.out.println(solution(a1,b1));
    int result1 = 1;

    int a2 = 12;
    int b2 = 21;
    System.out.println(solution(a2,b2));
    int result2 = 2;
  }

  public static int solution(int a, int b) {
    int max = 0;
    for (int i = 1; i <= a && i <= b; i++) {
      if (a % i == 0 && b % i == 0) {
        max = i;
      }
    }

    b /= max;

    if (b == 1) {
      return 1;
    }

    while (b % 2 == 0 || b % 5 == 0) {
      if (b % 2 == 0) {
        b /= 2;
      }
      if (b % 5 == 0) {
        b /= 5;
      }
      if (b == 1) {
        return 1;
      }
    }

    return 2;
  }
}
