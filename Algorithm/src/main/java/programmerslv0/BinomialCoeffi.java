package programmerslv0;

import java.util.Scanner;

public class BinomialCoeffi {

    public static void main(String[] args) {
        // n!/k!(n-k)!

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int k = in.nextInt();

        if (k >= N-k) {
            System.out.println(fac(N,k) / fac(N-k,1));
        } else {
            System.out.println(fac(N,N-k) / fac(k,1));
        }
    }
    static int fac(int a, int b) {

        int result = 1;

        for (int i = a; i > b; i--) {
            result *= i;
        }

        return result;
    }


}
