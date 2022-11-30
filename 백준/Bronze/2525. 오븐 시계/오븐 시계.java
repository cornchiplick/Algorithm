import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int hNow, mNow, timer;
        hNow = input.nextInt();
        mNow = input.nextInt();
        timer = input.nextInt();
        input.close();
        int mLater = (mNow+timer)%60;
        int dayAdd = (hNow+(mNow+timer)/60)%24;
        System.out.printf("%d %d",dayAdd, mLater);
    }
}