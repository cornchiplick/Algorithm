import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        int a, b;
        a = num.nextInt();
        b = num.nextInt();
        num.close();
        System.out.println(a*(b%10));
        System.out.println(a*((b/10)%10));
        System.out.println(a*(b/100));
        System.out.println(a*b);
    }
}