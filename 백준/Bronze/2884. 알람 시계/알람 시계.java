import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int H, M;
        H = input.nextInt();
        M = input.nextInt();
        input.close();
        if (H == 0 && M>=45) {
          M = M-45;
        } else if (H == 0 && M<45) {
          H = 23;
          M = M+15;
        }else if (H != 0 && M>=45) {
          M = M-45;
        } else if (true) {
          H = H-1;
          M = M+15;
        }
        System.out.printf("%d %d",H,M);
    }
}