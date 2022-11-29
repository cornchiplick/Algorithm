package programmerslv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UselessSnail {

  public static void main(String[] args) throws Exception {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine(), " ");

    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

    in.close();

    int result = (V-B) / (A-B);

    if ((V-B) % (A-B) != 0) {
      result++;
    }

    System.out.println(result);
  }
}


/*
v / (a-b) ==> hh
(a-b)*(hh-1) + a < v? hh+1 : hh



 */