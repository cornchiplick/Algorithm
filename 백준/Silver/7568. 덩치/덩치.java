import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder out = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    int[][] bmi = new int[N][2];

    for (int i = 0; i < N; i++) {
      StringTokenizer in = new StringTokenizer(br.readLine());
      bmi[i][0] = Integer.parseInt(in.nextToken());
      bmi[i][1] = Integer.parseInt(in.nextToken());
    }

    int count = 1;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (bmi[i][0] < bmi[j][0] && bmi[i][1] < bmi[j][1]) {
          count++;
        }
      }
      out.append(count).append(" ");
      count = 1;
    }
    System.out.println(out);
  }
}
