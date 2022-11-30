import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int value = (input.nextInt() * input.nextInt() * input.nextInt());
    input.close();
    String str = Integer.toString(value);
    int count = 0;
    int i = 0;
    int j = 0;
    while (true) {
      while (true) {
        if (i >= (str.length())) {
          break;
        }

        if (j == (str.charAt(i)-'0')) {
          count++;
        }
        i++;
      }
      
      i = 0;
      System.out.println(count);
      count = 0;
      
      if (j == 9) {
        break;
      }
      
      j++;

    }
  }
}