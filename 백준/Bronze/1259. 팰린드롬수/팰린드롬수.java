
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);


    while (in.hasNext()) {

      String str = in.next();

      if (str.equals("0")) {
        break;
      }

      checkno(str);

    }

  }



  static void checkno(String num) {

    if ((num.charAt(0) == '0') && (num.length() > 1)) {
      System.out.println("no");
      return;
    }

    for (int i = 0; i < num.length()/2; i++) {
      if (num.charAt(i) != num.charAt(num.length() - 1 - i)) {
        System.out.println("no");
        return;
      }
    }

    System.out.println("yes");
    return;
  }
}
