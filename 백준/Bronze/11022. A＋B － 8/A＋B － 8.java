import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int caseCount = input.nextInt();
    for (int i = 1; i <= caseCount; i++) {
      int A = input.nextInt();
      int B = input.nextInt();
          System.out.printf("Case #%d: %d + %d = %d\n",i,A,B,A+B);
    }
    input.close();
  }
}
