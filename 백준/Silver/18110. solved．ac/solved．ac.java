import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(Integer.parseInt(br.readLine()));
    }
    
    br.close();

    Collections.sort(list);
    int exclude = (int) Math.round(n * 0.15);
    int sum = 0;
    for (int i = exclude; i < n - exclude; i++) {
      sum += list.get(i);
    }

    double avgDouble = (double) sum / (n - exclude * 2);
    System.out.println((int) Math.round(avgDouble));
  }
}