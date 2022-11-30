import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int i = 1;
    int value;
    if (n < 10) {
      value = 10*n+n;
    } else {value = (n%10)*10+(n/10+n%10)%10;
    }
    while (true) {
      if ( n == value )
      break;
      
      i += 1;
      if (value < 10) {
        value = 10*value+value;
      } else {value = (value%10)*10+(value/10+value%10)%10;
      }
    }
    System.out.println(i);
    }
  }