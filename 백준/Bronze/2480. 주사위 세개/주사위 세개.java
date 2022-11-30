import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dice1, dice2, dice3;
        dice1 = input.nextInt();
        dice2 = input.nextInt();
        dice3 = input.nextInt();
        input.close();
        int price = 0;
        if (dice1 == dice2 && dice2 == dice3) {
          price = 10000 + dice1 * 1000;
        } else if (((dice1 == dice2) && (dice1 != dice3))) {
          price = 1000 + dice1 * 100;
        } else if ((dice2 == dice3) && (dice1 != dice3)) {
          price = 1000 + dice2 * 100;
        } else if ((dice1 == dice3) && (dice1 != dice2)) {
          price = 1000 + dice1 * 100;
        } else 
          price = (Math.max(Math.max(dice1,dice2),dice3))*100;
        System.out.println(price);
    }
}