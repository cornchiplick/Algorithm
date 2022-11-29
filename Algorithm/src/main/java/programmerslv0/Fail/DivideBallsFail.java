package programmerslv0.Fail;

// 성공했어요.
class DivideBallsFail {
  public static void main(String[] args) {
    for (int i = 1; i <= 30; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.printf("balls, share, answer: %d, %d, %d\n", i, j, solution(i, j));
      }
    }

  }

  public static int solution(int balls, int share) {
    long answer = 1;
    long balls2 = balls;
    long share2 = share;
    long i = balls2;
    long j = 1;
    if (balls2-share2 > share2) {
      while (j <= share2) {
        answer *= i;
        answer /= j;
        i--;
        j++;
      }
      return (int) answer;
    } else {
      while (j <= balls2-share2) {
        answer *= i;
        answer /= j;
        i--;
        j++;
      }
      return (int) answer;
    }
  }
}