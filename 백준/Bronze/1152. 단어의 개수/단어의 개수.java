import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String a = input.nextLine();
    input.close();
    int count = 1;
    int i = 0;
      
    if (a.charAt(0) == ' ') {
      count = count -  1;
    }
    if (a.charAt(a.length()-1) == ' ') {
      count = count - 1;
    }
    while (true) {
      if (i >= a.length()) {
        break;
      }

      if (a.charAt(i) == ' ') {
      count++;
      }
      i++;
    }
    
    System.out.println(count);

  }

}