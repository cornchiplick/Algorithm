import java.util.Scanner;
import java.lang.Math;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    int a = input.nextInt();
    int b = input.nextInt();
    int sna = -1;

    if (a%10 > b%10) {
      sna = a;
    } else if (a%10 < b%10) {
      sna = b;
    } else if (a%10 == b%10) {
        if ((a/10)%10 > (b/10)%10) {
        sna = a;
        } else if ((a/10)%10 < (b/10)%10) {
        sna = b;
        } else if ((a/10)%10 == (b/10)%10) {
            if (a/100 > b/100) {
            sna = a;
            } else if (a/100 < b/100) {
            sna = b;
            }
        }   
    }    

    int ans = (sna%10)*100 + ((sna/10)%10)*10 + (sna/100);

    System.out.println(ans);
    

  }
}