import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  
  static Queue<Integer> q2 = new LinkedList<>();
  static Queue<Integer> q5 = new LinkedList<>();
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    sc.close();


    for (int i = 1; i <= N; i++) {
      if (N == 0) {
        break;
      }
      
      calculate(i);
    }

    System.out.println(q5.size());
  }

  public static boolean calculate(int num) {
    if (num % 2 != 0 && num % 5 != 0) {
      return false;
    }

    while (num % 2 == 0) {
      num /= 2;
      q2.offer(1);
    }

    while (num % 5 == 0) {
      num /= 5;
      q5.offer(1);
    }
    
    return true;
  }
}