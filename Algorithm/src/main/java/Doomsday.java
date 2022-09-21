import java.util.Scanner;

public class Doomsday {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int count = 1;
        int num = 666;

        while (count != N) {
            num++;
            if (Integer.toString(num).contains("666")) {
                count++;
            }
        }
        System.out.println(num);

    }

}
/*
666
1666
2666
3666
4666
5666

6660
6661
6662
6663
6664
6665
6666
6667
6668
6669

7666
8666
9666
10666
11666
12
13
14
15
16666 / 16660
17666
*/