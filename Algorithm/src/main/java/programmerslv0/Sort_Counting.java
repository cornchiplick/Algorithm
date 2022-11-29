package programmerslv0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Sort_Counting {

  public static void main(String[] args) throws Exception {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(in.readLine());
    int[] cnt = new int[10000001];

    for (int i = 0; i < N; i++) {
    cnt[Integer.parseInt(in.readLine())]++;
    }

    in.close();

    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int i = 0; i <= 10001; i++) {
      while (cnt[i] > 0) {
        out.write(String.valueOf(i));
        out.write('\n');
        cnt[i]--;
      }
    }
    out.flush();

    out.close();
  }


}
