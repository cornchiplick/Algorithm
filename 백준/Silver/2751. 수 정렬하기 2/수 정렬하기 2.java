import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

      int N = Integer.parseInt(in.readLine());

      int[] arr = new int[N];

      for (int i = 0; i < N; i++) {
        arr[i] = Integer.parseInt(in.readLine());
      }

      Arrays.sort(arr);

      for (int i = 0; i < N; i++) {
        out.write(String.valueOf(arr[i]));
        out.write('\n');
      }
      out.flush();
    }
}
