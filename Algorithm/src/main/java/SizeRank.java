import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SizeRank {

  public static void main(String[] args) throws Exception {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder out = new StringBuilder();

    int N = Integer.parseInt(in.readLine());
    int[][] bmi = new int[N][2];

    for (int i = 0; i < N; i++) {
      bmi[i][0] = Integer.parseInt(in.readLine());
      bmi[i][1] = Integer.parseInt(in.readLine());
    }

    

  }
}
