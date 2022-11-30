
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    int[] arr = new int[8];

    for (int i = 0; i < 8; i++) {
      arr[i] = in.nextInt();
    }

    switch (arr[0]) {
      case 1 : {
        for (int i = 0; i < 7; i++) {
          if (arr[i] != arr[i+1]-1) {
            System.out.println("mixed");
            break;
          }
          if (i == 6) {
            System.out.println("ascending");
          }
        }
      } // c1
      break;

      case 8 : {
        for (int i = 0; i < 7; i++) {
          if (arr[i] != arr[i+1]+1) {
            System.out.println("mixed");
            break;
          }
          if (i == 6) {
            System.out.println("descending");
          }
        }
      } // c8
      break;

      default : System.out.println("mixed");

    } // switch
  }

}
