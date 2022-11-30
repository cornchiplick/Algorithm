import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    int len = in.nextInt();
    String str = in.next();
    int h = 0;


    for (int i = 0; i < len; i++) {
      h += (str.charAt(i) - 'a' + 1) * ((int) Math.pow(31, i));
    }

    System.out.println(h%1234567891);
  }
}
