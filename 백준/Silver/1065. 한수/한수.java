import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int input = sc.nextInt();
    sc.close();

    System.out.println(cntHanSu(input));

  }

  private static int cntHanSu(int n) {
    // 99이하라면 그 숫자만큼의 한수를 가진다
    if (n <= 99) {
      return n;
    }

    // 100 ~ 999
    if (n <= 999) {
      String num;
      int hundreds;
      int tens;
      int units;
      int count = 0;

      for (int i = 100; i <= n; i++) {
        num = String.valueOf(i);
        hundreds = Integer.parseInt(num.substring(0, 1));
        tens = Integer.parseInt(num.substring(1, 2));
        units = Integer.parseInt(num.substring(2));

        if (hundreds - tens == tens - units) {
          count++;
        }
      }

      return count + 99;
    }

    // 1000일 때는 999일 때와 같다.
    return cntHanSu(999);
  }
}
